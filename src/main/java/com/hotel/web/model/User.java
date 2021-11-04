/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User {

    private Long id;

    @NotEmpty(message = "The First name can't be null")
    private String firstName;

    @NotEmpty(message = "The Last name can't be null")
    private String lastName;

    @NotEmpty(message = "The Email can't be null")
    @Email(message = "The Email is not valid")
    private String email;

    @NotEmpty(message = "The Password can't be null")
    private String password;
    private  boolean isStudent;
    private boolean isManager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }


}
