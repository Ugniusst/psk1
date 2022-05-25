package com.example.psk1.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class FirstLevelAnimalNameLevelGenerator implements NameLevelGenerator{
    @Override
    public String generateNameLevel(String name) {
        return name + "_1";
    }
}
