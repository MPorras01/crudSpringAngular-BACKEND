package com.personalsoft.crudSpringAngular.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue
    @Column
    private Integer id ;
    @Column()
    private String name ;
    @Column()
    private String lastName ;
    @Column()
    private String Document ;
    @Column()
    private int age ;
    @Column()
    private int stature ;
    @Column()
    private String size ;
    @Column()
    private int weight ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String document) {
        Document = document;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStature() {
        return stature;
    }

    public void setStature(int stature) {
        this.stature = stature;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Person() {
    }

    public Person(Integer id, String name, String lastName, String document, int age, int stature, String size, int weight) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        Document = document;
        this.age = age;
        this.stature = stature;
        this.size = size;
        this.weight = weight;
    }
}
