package com.greenring.hackathon.domain.port.server;

import com.greenring.hackathon.domain.model.User;

import java.util.UUID;

public interface UserPersistenceSpi extends PersistenceSpi<User, UUID>{
}
