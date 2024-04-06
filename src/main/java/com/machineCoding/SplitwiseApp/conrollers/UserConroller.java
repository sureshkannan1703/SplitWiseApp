package com.machineCoding.SplitwiseApp.conrollers;

import com.machineCoding.SplitwiseApp.dtos.RegisterUserRequestDto;
import com.machineCoding.SplitwiseApp.dtos.RegisterUserResponseDto;
import com.machineCoding.SplitwiseApp.dtos.Response;
import com.machineCoding.SplitwiseApp.exceptions.RegisteruserException;
import com.machineCoding.SplitwiseApp.models.User;
import com.machineCoding.SplitwiseApp.exceptions.InvalidRequestException;
import com.machineCoding.SplitwiseApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto) {
        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        try {
            validateRequest(requestDto);
            User user = this.userService.registerUser(requestDto.getUserName(),requestDto.getPassword(),requestDto.getPhoneNumber());
        } catch (Exception e) {
            registerUserResponseDto.setResponse(Response.getFailureResponse(e.getMessage()));
        }
        return registerUserResponseDto;
    }

    public void validateRequest(RegisterUserRequestDto requestDto) throws InvalidRequestException {

        if(requestDto.getUserName()==null || requestDto.getPassword()==null || requestDto.getPhoneNumber()==null)
            throw  new InvalidRequestException("UserName or password or phoneNumber");
    }

}
