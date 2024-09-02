package com.example.vehicleservice.util;

import com.example.vehicleservice.dto.VehicleDTO;
import com.example.vehicleservice.entity.VehicleEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;

    public VehicleDTO toVehicleDTO (VehicleEntity vehicleEntity) {
        return mapper.map(vehicleEntity, VehicleDTO.class);
    }

    public VehicleEntity toVehicleEntity (VehicleDTO vehicleDTO) {
        return mapper.map(vehicleDTO, VehicleEntity.class);
    }

    public List<VehicleDTO> toVehicleDTOList(List<VehicleEntity> vehicleEntities) {
        return vehicleEntities.stream()
                .map(vehicleEntity -> mapper.map(vehicleEntity, VehicleDTO.class))
                .collect(Collectors.toList());
    }
}
