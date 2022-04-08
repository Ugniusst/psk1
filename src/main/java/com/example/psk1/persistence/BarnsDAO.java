package com.example.psk1.persistence;

import com.example.psk1.entities.Barn;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BarnsDAO {
    
    @Inject
    private EntityManager em;

    public List<Barn> loadAll() {
        return em.createNamedQuery("Barn.findAll", Barn.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Barn team){
        this.em.persist(team);
    }

    public Barn findOne(Long id) {
        return em.find(Barn.class, id);
    }

    public Barn update(Barn barn){
        return em.merge(barn);
    }
}
