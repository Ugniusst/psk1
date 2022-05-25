package com.example.psk1.decorators;

import com.example.psk1.services.NameLevelGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class AnimalNameDecorator implements NameLevelGenerator {
    @Inject
    @Delegate
    @Any
    NameLevelGenerator namelevelGenerator;

    public String generateNameLevel(String name) {
        String newName = namelevelGenerator.generateNameLevel(name);
        return newName.substring(0, 1).toUpperCase() + newName.substring(1);
    }

}
