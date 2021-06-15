package com.example.bankapp.service;

import com.example.bankapp.models.Category;
import com.example.bankapp.models.Operation;
import com.example.bankapp.models.User;
import com.example.bankapp.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OperationService {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private UserService userService;


    public void transfer(Long fromId, Long toId, Double cash) {
        User userFrom = userService.getUserById(fromId);
        User userTo = userService.getUserById(toId);
        if (userFrom.getCash() < cash) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        userFrom.setCash(userFrom.getCash() - cash);
        userTo.setCash(userTo.getCash() + cash);
        userService.saveUser(userFrom);
        userService.saveUser(userTo);
        operationRepository.save(new Operation(userFrom, userTo, cash, Category.TRANSFER));

    }

    public double getBalance(Long id) {
        User user = userService.getUserById(id);
        Double cash = user.getCash();
        operationRepository.save(new Operation(user, cash, Category.BALANCE));
        return cash;

    }

    public List<Operation> getHistory(Long id, Integer count) {
        User user = userService.getUserById(id);
        operationRepository.save(new Operation(user, Category.HISTORY));
        return operationRepository.findAllByUser(user);
    }
}
