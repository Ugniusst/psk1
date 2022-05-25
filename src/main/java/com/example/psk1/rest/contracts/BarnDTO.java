package com.example.psk1.rest.contracts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BarnDTO {
    private Integer id;

    private String name;

    private List<AnimalDTO> animals;

    private List<WorkerDTO> workers;
}
