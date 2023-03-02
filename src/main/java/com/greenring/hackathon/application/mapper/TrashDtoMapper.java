package com.greenring.hackathon.application.mapper;

import com.greenring.hackathon.application.dto.TrashCreationDto;
import com.greenring.hackathon.application.dto.TrashDto;
import com.greenring.hackathon.domain.model.Trash;

public interface TrashDtoMapper {

    static TrashDto toDto(Trash trash) {
        return new TrashDto(
                trash.get_id(),
                trash.getSite(),
                trash.getRoom(),
                trash.getColor()
        );
    }

    static Trash trashCreationToDomain(TrashCreationDto dto){
        return Trash.builder()
                .site(dto.site())
                .room(dto.room())
                .color(dto.color())
                .build();
    }
}
