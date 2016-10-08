package com.demo.entities;

import com.demo.common.enums.Test;
import com.demo.common.enums.UserStatus;
import com.google.gson.annotations.Expose;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/22.
 */
@Table(name = "user")
public class User extends baseEntity implements Serializable {
    private String name;
    private String age;
    private String sex;
    private String phone;
    private transient String password;
    private UserStatus status;
    private Test test;
    @Transient
    private UserRole userRole;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
