package com.example.psk1.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnimalNameLevelGenerator implements NameLevelGenerator{

    @Override
    public String generateNameLevel(String name) {
        return name + "_0";
    }
}
