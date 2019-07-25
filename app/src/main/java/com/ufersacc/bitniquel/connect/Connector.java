package com.ufersacc.bitniquel.connect;

import com.ufersacc.bitniquel.R;
import com.ufersacc.bitniquel.model.Client;
import com.ufersacc.bitniquel.model.Wallet;
import com.ufersacc.bitniquel.model.Transaction;

import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Connector {

    OkHttpClient client = new OkHttpClient();

    Client cliente = null;

    Client getCliente()
    {
        return cliente;
    }

    void setCliente(Client c)
    {
        cliente = c;
    }




    public Client login(String email, String password){


        Request.Builder builder =  new Request.Builder();
        builder.url("http://bitniquel.tk/client/login");
        RequestBody requestBody = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .build();

        builder.post(requestBody);

        final Request request = builder.build();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    try {
                        Response response = client.newCall(request).execute();
                        String s = response.body().string();
                        //InputStream stream = new ByteArrayInputStream(s.getBytes());
                        //JsonReader jr = new JsonReader(new InputStreamReader(stream));
                        JSONObject jsonObject = new JSONObject(s);
                        Object error = jsonObject.get("errorMessage");
                        if(error == null)
                        {
                            JSONObject objCliente = (JSONObject) jsonObject.get("result");
                            JSONObject objWallet = (JSONObject) objCliente.get("wallet");
                            Client c = new Client();
                            c.setId(Long.parseLong(objCliente.get("id").toString()));
                            c.setFullName((objCliente.get("fullName").toString()));
                            c.setFullName((objCliente.get("fullName").toString()));
                            c.setNickName((objCliente.get("nickName").toString()));
                            c.setEmail((objCliente.get("email").toString()));
                            Wallet w = new Wallet();
                            w.setId(Long.parseLong(objWallet.get("id").toString()));
                            w.setBitcoinAddress((objWallet.get("bitcoinAddress").toString()));
                            c.setWallet(w);
                            setCliente(c);


                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return cliente;
    }


    public Client signup(String fullName, String nickName, String birth, String email, String password, String ddi, String ddd, String phone, String postalCode){




    Request.Builder builder =  new Request.Builder();
    builder.url("http://bitniquel.tk/client/create");

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
