package com.ufersacc.bitniquel;

import android.content.Context;
import android.os.AsyncTask;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ufersacc.bitniquel.connect.ClientConnector;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

public class TokenLoginActivity extends AppCompatActivity  {

    SharedPreferences mPrefs;
    TokenLoginActivity tla;
    EditText editTextTokenLogin;
    TextView textTokenLogin;
    String idClient;
    TokenLoginActivity tk;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_token_login);
        tk = this;
        editTextTokenLogin = (EditText) findViewById(R.id.editTextTokenLogin);
        textTokenLogin = (TextView) findViewById(R.id.textTokenLogin);
        
        String menssage = getIntent().getExtras().getString("menssage");
        idClient = getIntent().getExtras().getString("idClient");
        
        textTokenLogin.setText(menssage);
        
        mPrefs = getSharedPreferences("USER_PREF", Context.MODE_PRIVATE);
        
    }

    public void confirmToken(View view){
        
        token = editTextTokenLogin.getText().toString();   Intent intent = new Intent(tk, PrincipalActivity.class);
                        startActivity(intent);

                        tk.finish();
        
        OkHttpHandler handler = new OkHttpHandler();
        handler.execute("");
        
    }
    
    public class OkHttpHandler extends AsyncTask<String,String,String>{
                
        @Override
        protected String doInBackground(String... params) {
            
            ClientConnector connector = new ClientConnector();
            
            Log.d("idClient", idClient);
            Log.d("token", token);
            
            return connector.confirmLogin(idClient, token);
            
        } 
        
        @Override
        protected void onPostExecute(String result){
            
            Log.d("TokenLoginActivity", "onPostExecute");
            
            if(result != null){
                
                Log.d("TokenLoginActivity", result);
                
                JsonObject json = new JsonParser().parse(result).getAsJsonObject();
                
                Object error = json.get("error");
                
                if(error != null){
                    
                    boolean erro = json.get("error").getAsBoolean();
                    
                    if(!erro){
                        
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        String client = json.get("client").toString();
                        prefsEditor.putString("Client", client);
                        prefsEditor.commit();





                        Intent intent = new Intent(tk, PrincipalActivity.class);
                        startActivity(intent);
                        
                        tk.finish();
                    }

                    else
                    {
                        Toast.makeText(tla, "Código Inválido", Toast.LENGTH_SHORT).show();
                    }

                }

            }

        }
        
    }
    
}
