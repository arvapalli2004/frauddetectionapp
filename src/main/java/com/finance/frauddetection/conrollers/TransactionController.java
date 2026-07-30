package com.finance.frauddetection.conrollers;

import com.finance.frauddetection.model.Transaction;
import com.finance.frauddetection.services.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private FraudDetectionService fraudDetectionService;
    public TransactionController(FraudDetectionService fraudDetectionService){
        this.fraudDetectionService=fraudDetectionService;

    }
    @GetMapping
    public List<Transaction> getAll(){

        return fraudDetectionService.getAllTransactions();
    }
    @GetMapping("/{id}")
    public Transaction getId(@PathVariable int id){
        return fraudDetectionService.getTransactionById(id);
    }
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return fraudDetectionService.processTransaction(transaction);
    }
}
