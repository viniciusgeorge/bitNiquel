package com.ufersacc.bitniquel.model;

public class Address {
   
    private long id;
    private int postalCode;
    private String street;
    private int number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private long lat;
    private long lng;
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    
    public int getPostalCode() {
        return postalCode;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    
    public String getNeighborhood() {
        return neighborhood;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setLat(long lat) {
        this.lat = lat;
    }
    
    public long getLat() {
        return lat;
    }
    
    public void setLng(long lng) {
        this.lng = lng;
    }
    
    public long getLng() {
        return lng;
    }
    
}
