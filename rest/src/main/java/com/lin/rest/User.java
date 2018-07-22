package com.lin.rest;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -7640328631062765787L;

    private String username;
    private String password;
}
