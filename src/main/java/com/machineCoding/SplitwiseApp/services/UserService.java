package com.machineCoding.SplitwiseApp.services;
import com.machineCoding.SplitwiseApp.exceptions.RegisteruserException;
import com.machineCoding.SplitwiseApp.models.User;

public interface UserService {

   public User registerUser(String userName, String password, String phoneNumber) throws RegisteruserException;

}
