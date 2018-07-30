package com.bmw.azure.jwt.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 2924915341795141568L;

    public String username;
    public String password;



}
