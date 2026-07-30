package com.finance.frauddetection.services;

import com.finance.frauddetection.model.Customer;
import com.finance.frauddetection.model.Transaction;
import com.finance.frauddetection.repository.CustomerRepository;
import com.finance.frauddetection.repository.ITransactionRepository;
import com.finance.frauddetection.repository.InMemoryTransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FraudDetectionService {
    private ITransactionRepository transactionRepository;
    private CustomerRepository customerRepository;
    public FraudDetectionService(ITransactionRepository transactionRepository, CustomerRepository customerRepository){
        this.transactionRepository=transactionRepository;
        this.customerRepository= customerRepository;
    }




    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
    //getTransactionById()
    public Transaction getTransactionById(int id){
        return transactionRepository.findById(id);
    }

    public Transaction processTransaction(Transaction transaction){
        int newGeneratedIdTxn=transactionRepository.save(transaction);
        transaction.setId(newGeneratedIdTxn);


        //fraud detection
        //rule 1-high amount
        List<String> reasons=new ArrayList<>();
        int riskScore=0;
        if(transaction.getAmount().compareTo(new BigDecimal("1000000")) > 0){
            reasons.add("High transaction amount Rs. ("+transaction.getAmount()+")");
            riskScore+=40;

        }

        //rule 2-odd hours
        int hour=transaction.getTxtTimeStamp().getHour();
        if(hour>=0&&hour<5){
            riskScore+=20;
        }
        //rule 3-location mismatch
        Customer customer= customerRepository.getCustomerById(transaction.getCustomerId());
        if(customer!=null&&!customer.getRegisteredCountry().equalsIgnoreCase(transaction.getTxnCountry())){
            reasons.add("Customer country mismatched: "+transaction.getTxnCountry());
            riskScore+=30;
        }
        if(!reasons.isEmpty()){
            //update transcation status as flagged
            transactionRepository.updateStatus(transaction.getId(),"FLAGGED");
        }else{
            //update transaction status as SUCCESS
            transactionRepository.updateStatus(transaction.getId(),"SUCCESS");
        }
        System.out.println(transaction);
        return transaction;
    }



}
