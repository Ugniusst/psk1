package com.example.psk1.persistence;

import com.example.psk1.entities.Animal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class AnimalsDAO {
    @Inject
    private EntityManager em;

    public void persist(Animal animal){
        this.em.persist(animal);
    }

    public Animal findOne(Integer id){
        return em.find(Animal.class, id);
    }

    public Animal update(Animal animal){
        Animal a = em.merge(animal);
        em.flush();
        return a;
    }
}
