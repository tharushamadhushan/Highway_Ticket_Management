package com.example.ticketservice.util;

import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.entity.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;

    public TicketDTO toTicketDTO (TicketEntity ticketEntity) {
        return mapper.map(ticketEntity, TicketDTO.class);
    }

    public TicketEntity toTicketEntity (TicketDTO ticketDTO) {
        return mapper.map(ticketDTO, TicketEntity.class);
    }

    public List<TicketDTO> toTicketDTOList(List<TicketEntity> ticketEntities) {
        return ticketEntities.stream()
                .map(ticketEntity -> mapper.map(ticketEntity, TicketDTO.class))
                .collect(Collectors.toList());
    }
}
