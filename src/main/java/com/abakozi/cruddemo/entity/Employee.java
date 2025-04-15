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

   @Column(name="first_name")
private String firstName;

   @Column(name="last_name")
   private String lastName;

   @Column(name="email")
   private String email;

   @Column(name="phone")
   private String phone;

   @ManyToOne
   @JoinColumn(name="department_id", nullable = false)
   private Department department;


   public Employee(){
          }

     public Employee(String firstName,String lastName, String email, String phone, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
