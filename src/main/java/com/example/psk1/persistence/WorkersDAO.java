package com.example.psk1.persistence;

import com.example.psk1.entities.Worker;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class WorkersDAO {
    @Inject
    private EntityManager em;

    public void persist(Worker worker){
        this.em.persist(worker);
    }

    public Worker findOne(Integer id){
        return em.find(Worker.class, id);
    }

    public Worker update(Worker worker){
        return em.merge(worker);
    }
}
