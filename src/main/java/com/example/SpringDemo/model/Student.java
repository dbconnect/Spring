package com.example.SpringDemo.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
