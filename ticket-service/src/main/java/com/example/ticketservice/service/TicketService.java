package com.example.ticketservice.service;

import com.example.ticketservice.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    TicketDTO saveTicket(TicketDTO ticketDTO);
    boolean deleteTicket(String ticketId);
    TicketDTO getSelectedTicket(String ticketId);
    List<TicketDTO> getAllTicket();
    boolean updateTicket(String ticketId, TicketDTO ticketDTO);
}
