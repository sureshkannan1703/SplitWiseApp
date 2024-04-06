package com.machineCoding.SplitwiseApp.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends BaseModel{

    private String userName;
    private String password;
    private String phoneNumber;

}
