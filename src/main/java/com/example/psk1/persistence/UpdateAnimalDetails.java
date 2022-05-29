package com.example.psk1.persistence;

import com.example.psk1.entities.Animal;
import com.example.psk1.interceptors.LoggedInvocation;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@ViewScoped
@Named
public class UpdateAnimalDetails implements Serializable {

    private Animal animal;

    @Inject
    private AnimalsDAO animalsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateAnimalDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer animalId = Integer.parseInt(requestParameters.get("animalId"));
        this.animal = animalsDAO.findOne(animalId);
    }

    @Transactional
    @LoggedInvocation
    public String updateAnimalName() {
        try{
            animalsDAO.update(this.animal);

        } catch (OptimisticLockException e) {
            return "/animalDetails.xhtml?faces-redirect=true&animalId=" + this.animal.getId() + "&error=optimistic-lock-exception";
        }
        return "index.xhtml";
    }
}
