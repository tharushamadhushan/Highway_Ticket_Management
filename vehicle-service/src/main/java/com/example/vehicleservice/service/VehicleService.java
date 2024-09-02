package com.example.vehicleservice.service;


import com.example.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);
    boolean deleteVehicle(String vehicleId);
    VehicleDTO getSelectedVehicle(String vehicleId);
    List<VehicleDTO> getAllVehicle();
    boolean updateVehicle(String vehicleId, VehicleDTO vehicleDTO);
}
