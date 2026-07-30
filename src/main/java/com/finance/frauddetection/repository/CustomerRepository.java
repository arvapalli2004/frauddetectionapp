package com.finance.frauddetection.repository;

import com.finance.frauddetection.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private List<Customer> customers=new ArrayList<>();
    public CustomerRepository(){
        customers.add(new Customer(1,"rupa","acc001","NIGERIA"));
        customers.add(new Customer(2,"neha","acc002","USA"));
        customers.add(new Customer(3,"mahi","acc003","INDIA"));
    }

    public List<Customer> getCustomers(){
        return customers;
    }
    public Customer getCustomerById(int id){
        return customers.stream().filter( customer -> customer.getId()==id).findFirst().orElse(null);

    }
}
