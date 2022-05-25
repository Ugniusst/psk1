package com.example.psk1.persistence;

import com.example.psk1.interceptors.LoggedInvocation;
import com.example.psk1.services.NameLevelGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateAnimalNameLevel implements Serializable {
    @Inject
    private NameLevelGenerator namelevelGenerator;

    private CompletableFuture<String> nameGeneratorTask = null;

    @LoggedInvocation
    public String generateNewName(String name) {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        nameGeneratorTask = CompletableFuture.supplyAsync(() -> namelevelGenerator.generateNameLevel(name));

        return  "/animalDetails.xhtml?faces-redirect=true&animalId=" + requestParameters.get("animalId");
    }

    public boolean isNameGenerationRunning() {
        return nameGeneratorTask != null && !nameGeneratorTask.isDone();
    }

    public String getNameGenerationStatus() throws ExecutionException, InterruptedException {
        if (nameGeneratorTask == null) {
            return null;
        } else if (isNameGenerationRunning()) {
            return "Name generation in progress";
        }
        return "Suggested Name: " + nameGeneratorTask.get();
    }
}
