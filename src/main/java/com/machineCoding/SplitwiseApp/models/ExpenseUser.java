package com.machineCoding.SplitwiseApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ExpenseUser extends BaseModel {

    private double amount;

    @Enumerated(value = EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;

}
