package com.greenring.hackathon.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Trash {
    String _id;
    String site;
    String room;
    String color;
}
