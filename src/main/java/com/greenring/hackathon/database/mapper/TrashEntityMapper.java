package com.greenring.hackathon.database.mapper;

import com.greenring.hackathon.database.entity.TrashEntity;
import com.greenring.hackathon.domain.model.Trash;

public interface TrashEntityMapper {
    static Trash toDomain(TrashEntity entity) {
        return Trash.builder()
                ._id(entity.get_id())
                .color(entity.getColor())
                .room(entity.getRoom())
                .site(entity.getSite())
                .build();
    }

    static TrashEntity fromDomain(Trash domain) {
        return TrashEntity.builder()
                ._id(domain.get_id())
                .color(domain.getColor())
                .room(domain.getRoom())
                .site(domain.getSite())
                .build();
    }
}
