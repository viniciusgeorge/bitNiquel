package com.ufersacc.bitniquel;

import android.os.AsyncTask;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.ufersacc.bitniquel.connect.ClientConnector;
import android.util.Log;
import android.widget.EditText;

public class TokenLoginActivity extends AppCompatActivity  {

    EditText editTextTokenLogin;
    String idClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_token_login);
        
        editTextTokenLogin = (EditText) findViewById(R.editTextTokenLogin);
        
    }
    
    public void confirmToken(View view){
        OkHttpHandler handler = new OkHttpHandler();
        handler.execute("");
    }
    
    public class OkHttpHandler extends AsyncTask<String,String,String>{
                
        @Override
        protected String doInBackground(String... params) {
            
            ClientConnector connector = new ClientConnector();
            
            String token = editTextTokenLogin.getText().toString();
            
            connector.confirmLogin(idClient, token);
            
            return null;
            
        } 
        
        @Override
        protected void onPostExecute(String result){
            
        }
        
    }
    
}
