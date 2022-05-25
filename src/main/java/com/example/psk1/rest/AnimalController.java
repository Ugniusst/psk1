package com.example.psk1.rest;

import com.example.psk1.entities.Animal;
import com.example.psk1.entities.Barn;
import com.example.psk1.persistence.AnimalsDAO;
import com.example.psk1.persistence.BarnsDAO;
import com.example.psk1.rest.contracts.AnimalDTO;
import com.example.psk1.rest.contracts.BarnDTO;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/animals")
public class AnimalController {

    @Inject
    @Getter
    @Setter
    private AnimalsDAO animalsDAO;

    @Inject
    @Getter
    @Setter
    private BarnsDAO barnsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Animal animal = animalsDAO.findOne(id);
        if (animal == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setName(animal.getName());

        Barn barn = animal.getBarn();
        BarnDTO barnDTO = new BarnDTO();
        barnDTO.setId(barn.getId());
        barnDTO.setName(barn.getName());

        animalDTO.setBarn(barnDTO);

        return Response.ok(animalDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer animalId,
            AnimalDTO animalDTO) {
        try {
            Animal existingAnimal = animalsDAO.findOne(animalId);
            if (existingAnimal == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingAnimal.setName(animalDTO.getName());
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setName(animalDTO.getName());
        
        Barn barn = barnsDAO.findOne(animalDTO.getBarn().getId());
        animal.setBarn(barn);
        animalsDAO.persist(animal);

        return Response.status(201).entity(animalDTO).build();
    }
}
