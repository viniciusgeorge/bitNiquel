package com.ufersacc.bitniquel.connect;

import com.ufersacc.bitniquel.R;
import com.ufersacc.bitniquel.model.Client;
import com.ufersacc.bitniquel.model.Wallet;
import com.ufersacc.bitniquel.model.Transaction;

import java.io.IOException;
import java.util.*;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Connector {

    OkHttpClient client = new OkHttpClient();

    public Client login(){
        
        return null;
    }
    
    public Client signup(String fullName, String nickName, String birth, String email, String password, String ddi, String ddd, String phone, String postalCode){




    Request.Builder builder =  new Request.Builder();
    builder.url("http://node10.codenvy.io:41097/client/create");

        RequestBody requestBody = new FormBody.Builder()
                .add("fullName", fullName)
                .add("nickName", nickName)
                .add("birth", birth)
                .add("email", email)
                .add("password", password)
                .add("ddi", ddi)
                .add("ddd", ddd)
                .add("phone", phone)
                .add("postalCode", postalCode)
                .build();

        builder.post(requestBody);

       final Request request = builder.build();


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {


                    try {
                        Response response = client.newCall(request).execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();




        return null;
    }
    
    public Wallet getWallet(Client client){
        
        return null;
    }
    
    public List<Transaction> getTransactions(Wallet wallet){
        
        return null;
    }
    
}