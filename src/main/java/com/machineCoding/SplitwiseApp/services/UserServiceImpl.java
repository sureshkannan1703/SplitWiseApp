package com.machineCoding.SplitwiseApp.services;

import com.machineCoding.SplitwiseApp.exceptions.RegisteruserException;
import com.machineCoding.SplitwiseApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.machineCoding.SplitwiseApp.models.User;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String userName, String password, String phoneNumber) throws RegisteruserException {

        Optional<User> existuser = this.userRepository.findUserByUserNameEqualsOrPhoneNumber(userName,phoneNumber);

        if(existuser.isPresent())
            throw new RegisteruserException("User Already Exist!");

        User user = new User();
        user.setUserName(userName); user.setPhoneNumber(phoneNumber);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        return this.userRepository.save(user);
    }

    public void login(String username, String password) throws RegisteruserException {

        User user = userRepository.findUserByUserName(username).orElseThrow(()-> new RegisteruserException("User not exist!!"));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(password,user.getPassword()))
            System.out.println("Login successfully!");
        else
            System.out.println("Invalid password!");
    }
}
