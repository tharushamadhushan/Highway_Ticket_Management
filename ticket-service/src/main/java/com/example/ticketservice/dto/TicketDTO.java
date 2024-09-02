package com.example.ticketservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDTO {
    private String ticketId;
    private Date issueDate;
    private String entranceLocate;
    private String exitLocate;
    private String vehicleNo;
}
