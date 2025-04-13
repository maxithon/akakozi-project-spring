package com.abakozi.cruddemo.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="d_employee")
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private UUID id;

   @Column(name="name")
private String name;

   @ManyToOne
   @JoinColumn(name="department_id", nullable = false)
   private Department department;

   public Employee(){
          }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
