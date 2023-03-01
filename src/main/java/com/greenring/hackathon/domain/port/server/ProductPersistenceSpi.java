package com.greenring.hackathon.domain.port.server;

import com.greenring.hackathon.domain.model.Product;

import java.util.UUID;

public interface ProductPersistenceSpi extends PersistenceSpi<Product, UUID>{
}
