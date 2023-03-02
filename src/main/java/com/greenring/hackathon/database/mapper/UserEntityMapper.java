package com.greenring.hackathon.database.mapper;

import com.greenring.hackathon.database.entity.UserEntity;
import com.greenring.hackathon.domain.model.User;

public interface UserEntityMapper {

    static User toDomain(UserEntity entity) {
        return User.builder()
                ._id(entity.get_id())
                .password(entity.getPassword())
                .lastname(entity.getLastname())
                .firstname(entity.getFirstname())
                .login(entity.getLogin())
                .coins(entity.getCoins())
                .admin(entity.getAdmin())
                .build();
    }

    static UserEntity fromDomain(User domain) {
        return UserEntity.builder()
                ._id(domain.get_id())
                .admin(domain.getAdmin())
                .coins(domain.getCoins())
                .firstname(domain.getFirstname())
                .lastname(domain.getLastname())
                .login(domain.getLogin())
                .password(domain.getPassword())
                .build();
    }
}
