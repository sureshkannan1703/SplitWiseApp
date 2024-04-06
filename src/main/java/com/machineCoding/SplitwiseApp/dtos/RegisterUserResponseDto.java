package com.machineCoding.SplitwiseApp.dtos;
import com.machineCoding.SplitwiseApp.models.User;
import lombok.Data;

@Data
public class RegisterUserResponseDto {

    User user;
    Response response;
}
