package com.machineCoding.SplitwiseApp.dtos;

import com.machineCoding.SplitwiseApp.models.Group;
import com.machineCoding.SplitwiseApp.models.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class SettleGroupResponseDto {

    private Response response;

    private List<Transaction> transactions;
}
