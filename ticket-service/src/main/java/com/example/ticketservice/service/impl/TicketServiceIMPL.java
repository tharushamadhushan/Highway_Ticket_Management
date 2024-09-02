package com.example.ticketservice.service.impl;

import com.example.ticketservice.dao.TicketRepo;
import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.entity.TicketEntity;
import com.example.ticketservice.service.TicketService;
import com.example.ticketservice.util.Mapping;
import com.example.ticketservice.util.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketServiceIMPL implements TicketService {

    private final TicketRepo ticketRepo;
    private final Mapping mapping;

    @Override
    public TicketDTO saveTicket(TicketDTO ticketDTO) {
        return mapping.toTicketDTO(ticketRepo.save(mapping.toTicketEntity(ticketDTO)));
    }

    @Override
    public boolean deleteTicket(String ticketId) {
        Optional<TicketEntity> ticket = ticketRepo.findById(ticketId);
        if (ticket.isPresent()) {
            ticketRepo.deleteById(ticketId);
            return true;
        }else{
            throw new NotFoundException(ticketId+" not found (:");
        }
    }

    @Override
    public TicketDTO getSelectedTicket(String ticketId) {
        return null;
    }

    @Override
    public List<TicketDTO> getAllTicket() {
        return mapping.toTicketDTOList(ticketRepo.findAll());
    }

    @Override
    public boolean updateTicket(String id, TicketDTO ticketDTO) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        Optional<TicketEntity> optionalTicket = ticketRepo.findById(id);
        if (optionalTicket.isPresent()) {
            TicketEntity ticket = optionalTicket.get();
            ticket.setIssueDate(ticketDTO.getIssueDate());
            ticket.setEntranceLocate(ticketDTO.getEntranceLocate());
            ticket.setExitLocate(ticketDTO.getExitLocate());
            ticket.setVehicleNo(ticketDTO.getVehicleNo());
            ticketRepo.save(ticket);
            return true;
        } else {
            throw new NotFoundException(id + " not found :(");
        }
    }
}
