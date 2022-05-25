package com.example.psk1.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDTO {
    private Integer id;

    private String name;

    private BarnDTO barn;
}
