package com.abakozi.cruddemo.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="d_department")
public class Department {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;

    public Department(){}

    public Department(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
