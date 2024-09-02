package com.example.userservice.util;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;

    //user
    public UserDTO toUserDTO(UserEntity user) {
        return  mapper.map(user, UserDTO.class);
    }
    public UserEntity toUserEntity(UserDTO userDTO){
        return  mapper.map(userDTO, UserEntity.class);
    }
    public List<UserDTO> toUserDTOList(List<UserEntity> users) {
        return mapper.map(users, List.class);

    }
}
