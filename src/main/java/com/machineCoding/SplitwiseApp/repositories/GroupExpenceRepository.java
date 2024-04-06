package com.machineCoding.SplitwiseApp.repositories;

import com.machineCoding.SplitwiseApp.models.GroupExpence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupExpenceRepository extends JpaRepository<GroupExpence , Integer> {


    List<GroupExpence> findAllByGroupId(int groupId);
}
