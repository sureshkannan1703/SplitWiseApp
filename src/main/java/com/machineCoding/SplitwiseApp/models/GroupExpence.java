package com.machineCoding.SplitwiseApp.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class GroupExpence extends BaseModel{

    @ManyToOne
    private Group group;

    @ManyToOne
    private Expense expense;

}
