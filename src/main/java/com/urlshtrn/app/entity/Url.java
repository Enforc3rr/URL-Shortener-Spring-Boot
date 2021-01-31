package com.urlshtrn.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Url {
    @Id
    private long id;
    private String oldAddress;
    
    private String newName;
    private String newAddress;

    public Url() {
    }

    public Url(String oldAddress, String newName, String newAddress) {
        this.oldAddress = oldAddress;
        this.newName = newName;
        this.newAddress = newAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOldAddress() {
        return oldAddress;
    }

    public void setOldAddress(String oldAddress) {
        this.oldAddress = oldAddress;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }
}
