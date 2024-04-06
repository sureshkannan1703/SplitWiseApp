package com.machineCoding.SplitwiseApp.services;

import com.machineCoding.SplitwiseApp.exceptions.InvalidRequestException;
import com.machineCoding.SplitwiseApp.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SettleUpService {

    public List<Transaction> settleGroup(int groupId) throws InvalidRequestException;

}
