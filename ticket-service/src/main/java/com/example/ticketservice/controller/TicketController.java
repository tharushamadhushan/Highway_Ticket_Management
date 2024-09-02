package com.example.ticketservice.controller;

import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.service.TicketService;
import com.example.ticketservice.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/health")
    public String healthTest() {
        return "Ticket Health Test";
    }

    @PostMapping
    public TicketDTO saveTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.saveTicket(ticketDTO);
    }

    @GetMapping
    public List<TicketDTO> getAllTicket() {
        return ticketService.getAllTicket();
    }

    @PatchMapping(value = "/{ticketId}")
    public boolean updateTicket(@RequestBody TicketDTO ticketDTO) throws NotFoundException {
        return ticketService.updateTicket(ticketDTO.getTicketId(),ticketDTO);
    }

    @DeleteMapping(value = "/{ticketId}")
    public boolean deleteTicket(@PathVariable ("ticketId") String id) throws NotFoundException {
        return ticketService.deleteTicket(id);
    }
}
