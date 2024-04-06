package com.machineCoding.SplitwiseApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Expense extends BaseModel{

    private double amount;

    private Date addedAt;

    private String description;

    private String proofUrl;

    @Enumerated(EnumType.ORDINAL)      //for JPA purpose => In db Oth enum value stored as 0, ist enum -> 1 by JPA.
    private Currency currency;

    @OneToMany
    private ExpenseUser expenseUser;

}
