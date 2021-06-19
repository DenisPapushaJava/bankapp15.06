package com.example.bankapp.repository;

import com.example.bankapp.models.Operation;
import com.example.bankapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findAllByUserFrom(User user);
}
