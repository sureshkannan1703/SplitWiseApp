package com.machineCoding.SplitwiseApp.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction extends BaseModel{

    @ManyToOne
    private int paidFrom;

    @ManyToOne
    private int paidTo;

    private double amount;
}
