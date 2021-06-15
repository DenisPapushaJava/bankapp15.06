package com.example.bankapp.controller;

import com.example.bankapp.dto.TransferDto;
import com.example.bankapp.models.Operation;
import com.example.bankapp.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/balance/{id}")
    public double getBalance(@PathVariable("id") Long id) {
        return operationService.getBalance(id);

    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferDto transferDto) {
        operationService.transfer(transferDto.getFromId(), transferDto.getToId(), transferDto.getCash());
    }

    @GetMapping("/history/{id}")
    public List<Operation> history(@PathVariable("id") Long id, @RequestParam(defaultValue = "10") Integer count) {
        return operationService.getHistory(id, count);
    }
}
