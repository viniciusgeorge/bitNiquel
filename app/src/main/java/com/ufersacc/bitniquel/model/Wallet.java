package com.ufersacc.bitniquel.model;

public class Wallet {
    
    private long id;
    private String bitcoinAddress;
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setBitcoinAddress(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }
    
    public String getBitcoinAddress() {
        return bitcoinAddress;
    }
    
}
