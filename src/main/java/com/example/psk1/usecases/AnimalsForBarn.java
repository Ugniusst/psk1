package com.example.psk1.usecases;

import com.example.psk1.entities.Animal;
import com.example.psk1.entities.Barn;
import com.example.psk1.interceptors.LoggedInvocation;
import com.example.psk1.persistence.AnimalsDAO;
import com.example.psk1.persistence.BarnsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class AnimalsForBarn {

    @Inject
    private BarnsDAO barnsDAO;

    @Inject
    private AnimalsDAO animalsDAO;

    @Getter
    @Setter
    private Barn barn;

    @Getter
    @Setter
    private int barnId;

    @Getter @Setter
    private Animal animalToCreate = new Animal();

    @PostConstruct
    public void init() {
        animalToCreate.setBarn(new Barn());
//        Map<String, String> requestParameters =
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        Integer barnId = Integer.parseInt(requestParameters.get("barnId"));
//        Barn nBarn = (barnsDAO.findOne((int) barn.getId()));
//        this.barn = (nBarn != null) ? nBarn : new Barn();
    }

    @Transactional
    @LoggedInvocation
    public void createAnimal() {
//        Barn nBarn =
//        animalToCreate.setBarn(this.barn);
        animalsDAO.persist(animalToCreate);
    }
}
