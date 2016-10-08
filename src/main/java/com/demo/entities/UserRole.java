package com.demo.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jie_r on 2016/9/5.
 */
@Table(name = "user_role")
public class UserRole {
    @Id
    @Expose
    private int id;
    @Expose
    private String name;

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
}
