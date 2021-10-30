package com.github.angleshq.angles.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Phase extends BaseModel {

    @Getter @Setter
    private String name;
    @Getter @Setter
    private Integer orderNumber;

    public Phase(String name, Integer orderNumber) {
        this.name = name;
        this.orderNumber = orderNumber;
    }
}
