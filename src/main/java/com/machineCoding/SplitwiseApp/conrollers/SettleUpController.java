package com.machineCoding.SplitwiseApp.conrollers;

import com.machineCoding.SplitwiseApp.dtos.Response;
import com.machineCoding.SplitwiseApp.dtos.SettleGroupRequestDto;
import com.machineCoding.SplitwiseApp.dtos.SettleGroupResponseDto;
import com.machineCoding.SplitwiseApp.exceptions.InvalidRequestException;
import com.machineCoding.SplitwiseApp.models.Group;
import com.machineCoding.SplitwiseApp.models.Transaction;
import com.machineCoding.SplitwiseApp.services.SettleUpService;
import com.machineCoding.SplitwiseApp.services.SettleUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

        SettleUpService settleUpService;

        @Autowired
        public SettleUpController(SettleUpService settleUpService){
            this.settleUpService = settleUpService;
        }

        public SettleGroupResponseDto settleGroup(SettleGroupRequestDto settleGroupRequestDto) throws InvalidRequestException {

            SettleGroupResponseDto responseDto = new SettleGroupResponseDto();

            if(settleGroupRequestDto.getGroupId() <= 0){
                throw new InvalidRequestException("Invalid Group Id");
            }
            try {
                List<Transaction> transactionList = settleUpService.settleGroup(settleGroupRequestDto.getGroupId());
                responseDto.setTransactions(transactionList);
                responseDto.setResponse(Response.getSuccessResponse());
            }
            catch(Exception e){
                responseDto.setResponse(Response.getFailureResponse(e.getMessage()));
            }
            return responseDto;
        }


}
