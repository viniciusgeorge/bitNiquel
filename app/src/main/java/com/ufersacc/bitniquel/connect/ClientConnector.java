package com.ufersacc.bitniquel.connect;

import android.os.AsyncTask;
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

public class ClientConnector {

    String baseUrl = "http://bitniquel.tk/";

    OkHttpClient client = new OkHttpClient();
    
    public String Signup(String...params){
    
        Request.Builder builder =  new Request.Builder();
        builder.url( baseUrl + "/client/create");

        RequestBody requestBody = new FormBody.Builder()
                .add("fullName", params[0])
                .add("nickName", params[1])
                .add("birth", params[2])
                .add("email", params[3])
                .add("password", params[4])
                .add("ddi", params[5])
                .add("ddd", params[6])
                .add("phone", params[7])
                .add("postalCode", params[8])
                .build();

        builder.post(requestBody);

        Request request = builder.build();
       
        try {
            
            Response response = client.newCall(request).execute();
            return response.body().string();
            
        } catch (Exception e){
            e.printStackTrace();
        }
       
        return null;
        
    }
    
    public String login(String email, String senha){
        
        Request.Builder builder =  new Request.Builder();
        builder.url( baseUrl + "/client/login");

        RequestBody requestBody = new FormBody.Builder()
                .add("email", email)
                .add("password", senha)
                .build();

        builder.post(requestBody);

        Request request = builder.build();
       
        try {
            
            Response response = client.newCall(request).execute();
            return response.body().string();
            
        } catch (Exception e){
            e.printStackTrace();
        }
       
        return null;
        
    }
    
    public String confirmLogin(String idClient, String token){
        
        Request.Builder builder =  new Request.Builder();
        builder.url( baseUrl + "/client/confirmLogin");

        RequestBody requestBody = new FormBody.Builder()
                .add("idClient", idClient)
                .add("token", token)
                .build();

        builder.post(requestBody);

        Request request = builder.build();
       
        try {
            
            Response response = client.newCall(request).execute();
            return response.body().string();
            
        } catch (Exception e){
            e.printStackTrace();
        }
       
        return null;
        
    }
    
}
