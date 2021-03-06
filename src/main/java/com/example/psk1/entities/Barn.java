package com.example.psk1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@NamedQueries({
        @NamedQuery(name = "Barn.findAll", query = "select t from Barn as t")
})
@Table(name = "BARN")
@Getter @Setter
public class Barn implements Serializable {
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

    private List<Animal> animals;

    @OneToMany(mappedBy = "barn")
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    private List<Worker> workers;

    @ManyToMany(mappedBy = "barns")
    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barn barn = (Barn) o;
        return Objects.equals(name, barn.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private int version;
}
