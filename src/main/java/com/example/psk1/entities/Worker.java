package com.example.psk1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Worker {
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
