package com.example.ticketservice.dao;

import com.example.ticketservice.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity, String> {
}
