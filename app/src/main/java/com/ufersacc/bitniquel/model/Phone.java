package com.ufersacc.bitniquel.model;

public class Phone {
    
    private long id;
    private int ddi;
    private int ddd;
    private int number;
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setDdi(int ddi) {
        this.ddi = ddi;
    }
    
    public int getDdi() {
        return ddi;
    }
    
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }
    
    public int getDdd() {
        return ddd;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public int getNumber() {
        return number;
    }
    
}
