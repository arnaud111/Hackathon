package com.greenring.hackathon.domain.port.server;

import com.greenring.hackathon.domain.model.Distributor;

import java.util.UUID;

public interface DistributorPersistenceSpi extends PersistenceSpi<Distributor, UUID> {
}
