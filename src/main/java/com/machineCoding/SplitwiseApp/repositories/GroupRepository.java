package com.machineCoding.SplitwiseApp.repositories;

import com.machineCoding.SplitwiseApp.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {

    @Override
    public Optional<Group> findById(Integer integer);
}
