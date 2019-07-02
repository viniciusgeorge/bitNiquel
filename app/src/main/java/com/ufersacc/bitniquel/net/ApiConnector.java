package com.ufersacc.bitniquel;

import com.ufersacc.bitniquel.model.Client;

public class ApiConnector {

    private String baseUrl = "http://bitniquel.tk/api/";
    
    public Client getClient(String email, String password){
        
        Client client = new Client();
        
        return client;
        
    }
}
