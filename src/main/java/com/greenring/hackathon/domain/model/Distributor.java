package com.greenring.hackathon.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Distributor {
    @Builder.Default UUID _id = UUID.randomUUID();
    String name;
    String room;
    @Builder.Default List<Product> products = new ArrayList<>();

    public Distributor deleteProduct(Product product){
        this.products.remove(product);
        return new Distributor(
                this._id,
                this.name,
                this.room,
                this.products
        );
    }
}
