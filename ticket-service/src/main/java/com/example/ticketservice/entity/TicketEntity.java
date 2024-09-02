package com.example.ticketservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    private String ticketId;
    private Date issueDate;
    private String entranceLocate;
    private String exitLocate;
    private String vehicleNo;
}
