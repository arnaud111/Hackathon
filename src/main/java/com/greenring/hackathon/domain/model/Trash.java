package com.greenring.hackathon.domain.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Trash {
    @Builder.Default UUID _id = UUID.randomUUID();
    String site;
    String room;
    String color;
}
