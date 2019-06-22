package com.ufersacc.bitniquel.model;

import java.util.Date;

public class Transaction {
    
    private long id;
    private Wallet wallet;
    private String bitcoinAddressSource;
    private String bitcoinAddressDestination;
    private Date dateTime;
    private String description;
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    
    public Wallet getWallet() {
        return wallet;
    }
    
    public void setBitcoinAddressSource(String bitcoinAddressSource) {
        this.bitcoinAddressSource = bitcoinAddressSource;
    }
    
    public String getBitcoinAddressSource() {
        return bitcoinAddressSource;
    }
    
    public void setBitcoinAddressDestination(String bitcoinAddressDestination) {
        this.bitcoinAddressDestination = bitcoinAddressDestination;
    }
    
    public String getBitcoinAddressDestination() {
        return bitcoinAddressDestination;
    }
    
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    public Date getDateTime() {
        return dateTime;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
}
