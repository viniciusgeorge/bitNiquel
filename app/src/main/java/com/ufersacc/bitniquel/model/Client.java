package com.ufersacc.bitniquel.model;

import java.util.Date;

public class Client {
    
    private long id;
    private String fullName;
    private String nickName;
    private Date birth;
    private String email;
    private String password;
    private int document;
    private Phone phone;
    private Address address;
    private Wallet wallet;
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    
    public Date getBirth() {
        return birth;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setDocument(int document) {
        this.document = document;
    }
    
    public int getDocument() {
        return document;
    }
    
    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    
    public Phone getPhone() {
        return phone;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public Address getAddress() {
        return address;
    }

    public void setWallet(Wallet wallet) {this.wallet = wallet;}

    public Wallet getWallet() {return wallet;}
}
