package com.example.psk1.usecases;

import com.example.psk1.entities.Worker;
import com.example.psk1.entities.Barn;
import com.example.psk1.interceptors.LoggedInvocation;
import com.example.psk1.persistence.WorkersDAO;
import com.example.psk1.persistence.BarnsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class WorkersForBarn {

    @Inject
    private BarnsDAO barnsDAO;

    @Inject
    private WorkersDAO workersDAO;

    @Getter
    @Setter
    private Barn barn;

    @Getter
    @Setter
    private int barnId;

    @Getter @Setter
    private Worker workerToCreate = new Worker();

    @PostConstruct
    public void init() {

        this.barn = new Barn();
        workerToCreate.setBarns(new ArrayList<Barn>());

//        Map<String, String> requestParameters =
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        Integer barnId = Integer.parseInt(requestParameters.get("barnId"));
//        Barn nBarn = (barnsDAO.findOne((int) barn.getId()));
//        this.barn = (nBarn != null) ? nBarn : new Barn();
    }

    @Transactional
    @LoggedInvocation
    public void createWorker() {
        Barn nBarn = (barnsDAO.findOne(this.barn.getId()));
        this.barn = (nBarn != null) ? nBarn : new Barn();

        List<Barn> barns = workerToCreate.getBarns();
        if(barns == null) {
            barns = new ArrayList<Barn>();
        }
        barns.add(this.barn);
        workerToCreate.setBarns(barns);
        workersDAO.persist(workerToCreate);

        List<Worker> workers = this.barn.getWorkers();
        if(workers == null) {
            workers = new ArrayList<Worker>();
        }
        workers.add(workerToCreate);
        this.barn.setWorkers(workers);
        barnsDAO.update(this.barn);
    }
}
