package com.example.vehicleservice.service.impl;

import com.example.vehicleservice.dao.VehicleRepo;
import com.example.vehicleservice.dto.VehicleDTO;
import com.example.vehicleservice.entity.VehicleEntity;
import com.example.vehicleservice.service.VehicleService;
import com.example.vehicleservice.util.Mapping;
import com.example.vehicleservice.util.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceIMPL implements VehicleService {

    private final VehicleRepo vehicleRepo;
    private final Mapping mapping;
    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
//        vehicleDTO.setVehicleId(UUID.randomUUID().toString());
        return mapping.toVehicleDTO(vehicleRepo.save(mapping.toVehicleEntity(vehicleDTO)));
    }

    @Override
    public boolean deleteVehicle(String vehicleId) {
        Optional<VehicleEntity> vehicle = vehicleRepo.findById(vehicleId);
        if (vehicle.isPresent()) {
            vehicleRepo.deleteById(vehicleId);
            return true;
        }else{
            throw new NotFoundException(vehicleId+" not found (:");
        }
    }

    @Override
    public VehicleDTO getSelectedVehicle(String vehicleId) {
        return null;
    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return mapping.toVehicleDTOList(vehicleRepo.findAll());

    }

    @Override
    public boolean updateVehicle(String id, VehicleDTO vehicleDTO) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        Optional<VehicleEntity> optionalVehicle = vehicleRepo.findById(id);
        if (optionalVehicle.isPresent()) {
            VehicleEntity vehicle = optionalVehicle.get();
            vehicle.setVehicleType(vehicleDTO.getVehicleType());
            vehicleRepo.save(vehicle);
            return true;
        } else {
            throw new NotFoundException(id + " not found :(");
        }
    }
}
