package com.ufersacc.bitniquel.model;

import java.math.BigDecimal;

public class Wallet {
    
    private long id;
    private String bitcoinAddress;
    private BigDecimal currentBalance;
    private BigDecimal currentBalanceUsd;
    private BigDecimal currentBalanceBrl;

    public BigDecimal getCurrentBalanceUsd() {
        return currentBalanceUsd;
    }

    public void setCurrentBalanceUsd(BigDecimal currentBalanceUsd) {
        this.currentBalanceUsd = currentBalanceUsd;
    }

    public BigDecimal getCurrentBalanceBrl() {
        return currentBalanceBrl;
    }

    public void setCurrentBalanceBrl(BigDecimal currentBalanceBrl) {
        currentBalanceBrl = currentBalanceBrl;
    }


    
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
    
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
    
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
    
}
