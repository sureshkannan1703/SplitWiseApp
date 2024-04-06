package com.machineCoding.SplitwiseApp.services;

import com.machineCoding.SplitwiseApp.exceptions.InvalidRequestException;
import com.machineCoding.SplitwiseApp.models.*;
import com.machineCoding.SplitwiseApp.repositories.GroupExpenceRepository;
import com.machineCoding.SplitwiseApp.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SettleUpServiceImpl implements SettleUpService {

        GroupRepository groupRepository;
        GroupExpenceRepository groupExpenceRepository;

        @Autowired
        public SettleUpServiceImpl(GroupRepository groupRepository,  GroupExpenceRepository groupExpenceRepository){
            this.groupRepository = groupRepository;
            this.groupExpenceRepository = groupExpenceRepository;
        }

        public List<Transaction> settleGroup(int groupId) {

            try {
                Optional<Group> group = Optional.ofNullable(this.groupRepository.findById(groupId).orElseThrow(() -> new InvalidRequestException("Group not exist")));
                List<GroupExpence> groupExpencesList = this.groupExpenceRepository.findAllByGroupId(groupId);
                List<Expense> expences = groupExpencesList.stream().map(GroupExpence::getExpense).toList();

                Map<User, Double> userTotal = new HashMap<>();

//                for(Expense expense : expences){
//                    for(ExpenseUser expenseuser : expense.getExpenseUser()){
//                        userTotal.put(expenseuser.getUser(),
//                                user)
//                    }
//
//
//                }



            } catch (InvalidRequestException e) {
                throw new RuntimeException(e);
            }
            return null;

        }



}
