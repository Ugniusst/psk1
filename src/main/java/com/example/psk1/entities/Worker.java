package com.example.psk1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Worker {
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Barn> barns;

    @ManyToMany
    public List<Barn> getBarns() {
        return barns;
    }

    public void setBarns(List<Barn> barns) {
        this.barns = barns;
    }

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    @Getter @Setter
    private Integer version;
}
