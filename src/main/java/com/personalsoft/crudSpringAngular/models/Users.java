package com.personalsoft.crudSpringAngular.models;


import javax.persistence.*;


@Entity
@Table
public class Users {

    @Id
    @GeneratedValue
    @Column
    private int id ;
    @Column()
    private int documentNumber ;
    @Column()
    private String name ;
    @Column()
    private String userName;
    @Column()
    private String password ;


    public Users() {
    }

    public Users(int id, int documentNumber, String name, String userName, String password) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", documentNumber=" + documentNumber +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
