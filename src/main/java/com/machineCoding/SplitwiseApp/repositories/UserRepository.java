package com.machineCoding.SplitwiseApp.repositories;

import com.machineCoding.SplitwiseApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

     public Optional<User> findUserByUserNameEqualsOrPhoneNumber(String userName, String password);

     public Optional<User> findUserByUserName(String userName);
}
