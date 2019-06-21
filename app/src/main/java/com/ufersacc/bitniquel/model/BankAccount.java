package com.ufersacc.bitniquel.model;

public class BankAccount {
    
    private long id;
    private Client client;
    private int bankNumber;
    private int branchNumber;
    private int accountNumber;
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setClient(Client client){
        this.client = client;
    }
    
    public Client getClient(){
        return client;
    }
    
    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }
    
    public int getBankNumber() {
        return bankNumber;
    }
    
    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }
    
    public int getBranchNumber() {
        return branchNumber;
    }
    
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
}
