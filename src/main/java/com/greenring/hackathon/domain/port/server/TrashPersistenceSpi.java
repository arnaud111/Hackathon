package com.greenring.hackathon.domain.port.server;

import com.greenring.hackathon.domain.model.Trash;
import io.vavr.control.Option;

import java.util.UUID;

public interface TrashPersistenceSpi extends PersistenceSpi<Trash, UUID>{

    Option<Trash> deleteBy_id(UUID id);
}
