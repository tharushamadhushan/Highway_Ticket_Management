package com.example.vehicleservice.dao;

import com.example.vehicleservice.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VehicleRepo extends JpaRepository<VehicleEntity, String>{
//    List<VehicleEntity> findByUserId(String userId);
}
