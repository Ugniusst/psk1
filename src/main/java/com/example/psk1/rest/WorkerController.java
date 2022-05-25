package com.example.psk1.rest;

import com.example.psk1.entities.Animal;
import com.example.psk1.entities.Worker;
import com.example.psk1.entities.Barn;
import com.example.psk1.persistence.WorkersDAO;
import com.example.psk1.persistence.BarnsDAO;
import com.example.psk1.rest.contracts.WorkerDTO;
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
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/workers")
public class WorkerController {
    @Inject
    @Getter
    @Setter
    private WorkersDAO workersDAO;

    @Inject
    @Getter
    @Setter
    private BarnsDAO barnsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Worker worker = workersDAO.findOne(id);
        if (worker == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setId(worker.getId());
        workerDTO.setName(worker.getName());

        List<BarnDTO> barnDTOS = new ArrayList<>();

        for (Barn barn : worker.getBarns()) {
            BarnDTO barnDTO = new BarnDTO();
            barnDTO.setId(barn.getId());
            barnDTO.setName(barn.getName());

            barnDTOS.add(barnDTO);
        }
        workerDTO.setBarns(barnDTOS);

        return Response.ok(workerDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer workerId,
            WorkerDTO workerDTO) {
        try {
            Worker existingWorker = workersDAO.findOne(workerId);
            if (existingWorker == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingWorker.setName(workerDTO.getName());

            List<Barn> barns = existingWorker.getBarns();
            for(BarnDTO a : workerDTO.getBarns()) {
                Barn barn = barnsDAO.findOne(a.getId());
                barns.add(barn);
            }
            existingWorker.setBarns(barns);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

//    @POST
//    @Path("/post/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Transactional
//    public Response createWorker(WorkerDTO workerDTO) {
//        Worker worker = new Worker();
//        worker.setName(workerDTO.getName());
//
//        Barn barn = barnsDAO.findOne(workerDTO.getBarn().getId());
//        worker.setBarn(barn);
//        workersDAO.persist(worker);
//
//        return Response.status(201).entity(workerDTO).build();
//    }
}
