package com.example.psk1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Animal implements Serializable {
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

    @Getter @Setter
    @Version
    @Column(name = "optLockVersion",nullable = false)
    private Integer version1;

    @Column(name = "optLockVersion",nullable = false)
    @Version
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
