package com.example.psk1.entities;

import javax.persistence.*;

@Entity
public class Animal {
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

    @Column(name="animalName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Barn barn;

    @ManyToOne
    public Barn getBarn() {
        return barn;
    }

    public void setBarn(Barn barn) {
        this.barn = barn;
    }
}
