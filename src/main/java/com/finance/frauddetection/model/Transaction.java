package com.finance.frauddetection.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    public LocalDateTime txnTimeStamp;
    public int id;

    public BigDecimal amount;
    public String status;
    public String txnCountry;
    public String txnDate;
    public int customerId;
    public Transaction(){

    }

    public Transaction(int id, int customerId, BigDecimal amount, String txnCountry, LocalDateTime txnTimestamp, String status) {

        this.id=id;
        this.customerId=customerId;
        this.amount=amount;
        this.txnCountry=txnCountry;
        this.txnTimeStamp=txnTimestamp;
        this.status=status;

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getTxnCountry() {
        return txnCountry;
    }

    public void setTxnCountry(String txnCountry) {
        this.txnCountry = txnCountry;
    }



    public Transaction(LocalDateTime txnTimeStamp, int id) {
        this.txnTimeStamp = txnTimeStamp;
        this.id = id;
    }

    public Transaction(LocalDateTime txnTimeStamp) {
        this.txnTimeStamp = txnTimeStamp;
    }

    public Transaction(LocalDateTime txnTimeStamp, BigDecimal amount) {
        this.txnTimeStamp = txnTimeStamp;
        this.amount = amount;
    }

    public LocalDateTime getTxtTimeStamp() {
        return txnTimeStamp;
    }

    public void setTxtTimeStamp(LocalDateTime txtTimeStamp) {
        this.txnTimeStamp = txnTimeStamp;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
