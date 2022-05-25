package com.example.psk1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table

public class Animal {
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

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    @Getter @Setter
    private Integer version;

}
