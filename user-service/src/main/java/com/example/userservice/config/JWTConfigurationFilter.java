package com.example.userservice.config;

import com.example.userservice.service.JWTService;
import com.example.userservice.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JWTConfigurationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UserService userService;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        final  String userEmail;
        final String jwt;
        final String authorizationHeader =request.getHeader("Authorization");

        //validation - Get Auth Header Status
        if (StringUtils.isEmpty(authorizationHeader) || ! authorizationHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        jwt= authorizationHeader.substring(7);
        userEmail = jwtService.extractUserName(jwt);

        //validation -Email validation and status of SecurityContextHolder
        if (StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails =
                    userService.userDetailService().loadUserByUsername(userEmail);

            //Validation Token Status
            if (jwtService.isTokenValid(jwt,userDetails)){
                SecurityContext emptyContext
                        = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails , null , userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                emptyContext.setAuthentication(authToken);
                SecurityContextHolder.setContext(emptyContext);
            }
        }
        filterChain.doFilter(request,response);
    }
}
