package com.example.psk1.usecases;

import com.example.psk1.mybatis.dao.AnimalMapper;
import com.example.psk1.mybatis.model.Animal;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class AnimalsMyBatis {
    @Inject
    private AnimalMapper animalMapper;

    @Getter
    private List<Animal> allAnimals;

    @Getter @Setter
    private Long barnId;
    @Getter @Setter
    private Animal animalToCreate = new Animal();

    @PostConstruct
    public void init() {
        this.loadAllAnimals();
    }

    private void loadAllAnimals() {
        this.allAnimals = animalMapper.selectAll();
    }

    @Transactional
    public String createAnimal() {
        animalToCreate.setBarnId(this.barnId);
        animalMapper.insert(animalToCreate);
        return "barns?faces-redirect=true";
    }
}
