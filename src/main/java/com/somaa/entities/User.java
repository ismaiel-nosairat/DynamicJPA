/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somaa.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author Ismaiel
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    
    @NotNull
    @Column(name="name1")
    public String name;
    
    @NotNull
    public double salary;

    public User() {
    }

    public User( String name, double salary) {
    
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
}
