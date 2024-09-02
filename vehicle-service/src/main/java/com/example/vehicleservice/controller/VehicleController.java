package com.example.vehicleservice.controller;

import com.example.vehicleservice.dto.VehicleDTO;
import com.example.vehicleservice.service.VehicleService;
import com.example.vehicleservice.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/health")
    public String healthTest() {
        return "Vehicle Health Test";
    }

    @PostMapping
    public VehicleDTO saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.saveVehicle(vehicleDTO);
    }

    @GetMapping
    public List<VehicleDTO> getAllVehicle() {
        return vehicleService.getAllVehicle();
    }

    @PatchMapping(value = "/{vehicleId}")
    public boolean updateVehicle(@RequestBody VehicleDTO vehicleDTO) throws NotFoundException {
        return vehicleService.updateVehicle(vehicleDTO.getVehicleId(),vehicleDTO);
    }

    @DeleteMapping(value = "/{vehicleId}")
    public boolean deleteVehicle(@PathVariable ("vehicleId") String id) throws NotFoundException {
        return vehicleService.deleteVehicle(id);
    }

}
