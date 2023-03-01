package com.greenring.hackathon.domain.model;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Distributor {
    String _id;
    String name;
    String room;
    List<Product> products;
}
