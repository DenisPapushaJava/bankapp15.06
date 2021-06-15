package com.example.bankapp.repository;

import com.example.bankapp.models.Operation;
import com.example.bankapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
  //  @Query(value = "SELECT * FROM Operation ORDER BY date DESC LIMIT :count", nativeQuery = true)
    List<Operation> findAllByUser(User user);
}
