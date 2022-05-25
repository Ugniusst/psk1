package com.example.psk1.services;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
public class SecondLevelAnimalNameLevelGenerator extends AnimalNameLevelGenerator{
    @Override
    public String generateNameLevel(String name) {
        try {
            Thread.sleep(100000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        return name + "_2";
    }
}
