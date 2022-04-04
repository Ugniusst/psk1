package com.example.psk1.usecases;

import com.example.psk1.entities.Barn;
import com.example.psk1.persistence.BarnsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Barns {
    @Inject
    private BarnsDAO barnsDAO;

    @Getter @Setter
    private Barn barnToCreate = new Barn();

    @Getter
    private List<Barn> allBarns;

    @PostConstruct
    public void init(){
        loadAllBarns();
    }

    @Transactional
    public void createBarn(){
        this.barnsDAO.persist(barnToCreate);
    }

    private void loadAllBarns(){
        this.allBarns = barnsDAO.loadAll();
    }
}
