package com.example.psk1.usecases;

import com.example.psk1.mybatis.dao.BarnMapper;
import com.example.psk1.mybatis.model.Barn;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class BarnsMyBatis {
    @Inject
    private BarnMapper barnMapper;

    @Getter
    private List<Barn> allBarns;

    @Getter @Setter
    private Barn barnToCreate = new Barn();

    @PostConstruct
    public void init() {
        this.loadAllBarns();
    }

    private void loadAllBarns() {
        this.allBarns = barnMapper.selectAll();
    }

    @Transactional
    public String createBarn() {
        barnMapper.insert(barnToCreate);
        return "barns?faces-redirect=true";
    }
}
