package com.greenring.hackathon.application.mapper;

import com.greenring.hackathon.application.dto.DistributorCreationDto;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.application.dto.DistributorDto;

public interface DistributorDtoMapper {
    static DistributorDto toDto(Distributor distributor) {
        return new DistributorDto(
                distributor.get_id(),
                distributor.getName(),
                distributor.getRoom(),
                distributor.getProducts());
    }

    static Distributor distributorCreationToDomain(DistributorCreationDto dto){
        return Distributor.builder()
                .room(dto.room())
                .name(dto.name())
                .build();
    }
}
