package com.example.vpn.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private double amount;

    private boolean transactionStatus;

    private long amountdeducted;

    private Date date;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    Refund refund;
    public Transaction(double amount, boolean transactionStatus, long amountdeducted, Date date) {
        this.amount = amount;
        this.transactionStatus = transactionStatus;
        this.amountdeducted = amountdeducted;
        this.date = date;
    }

    public Transaction() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public long getAmountdeducted() {
        return amountdeducted;
    }

    public void setAmountdeducted(long amountdeducted) {
        this.amountdeducted = amountdeducted;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Refund getRefund() {
        return refund;
    }

    public void setRefund(Refund refund) {
        this.refund = refund;
    }
}
