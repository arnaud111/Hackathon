package com.greenring.hackathon.domain.port.server;

import com.greenring.hackathon.domain.model.Trash;

import java.util.UUID;

public interface TrashPersistenceSpi extends PersistenceSpi<Trash, UUID>{
}
