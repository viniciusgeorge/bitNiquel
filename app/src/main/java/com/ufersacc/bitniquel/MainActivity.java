package com.ufersacc.bitniquel;

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



public class MainActivity extends AppCompatActivity  {

    EditText editTextEmail;
    EditText editTextSenha;
    MainActivity ma;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ma= this;
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextSenha = (EditText) findViewById(R.id.editTextSenha);
        
    }

    public void telaPrincipal(View view)
    {
        //Intent intent = new Intent(this, PrincipalActivity.class);
        //startActivity(intent);
        
        OkHttpHandler okHttpHandler= new OkHttpHandler();
        okHttpHandler.execute("url");

    }

    public void telaRegistro(View view)
    {
        Intent intent = new Intent( this, RegistroActivity.class);
        startActivity(intent);

    }
    
    public class OkHttpHandler extends AsyncTask<String,String,String>{
                
        @Override
        protected String doInBackground(String... params) {
            
            ClientConnector connector = new ClientConnector();
            
            String email = editTextEmail.getText().toString();
            String senha = editTextSenha.getText().toString();
            
            Log.d("Teste", email + " - " + senha);
            
            return connector.login(email,senha);
        } 
        
        @Override
        protected void onPostExecute(String result){
            
            Log.d("Teste", "onPostExecute");
            
            if(result != null){
                
                Log.d("Teste", result);
                
                JsonObject json = new JsonParser().parse(result).getAsJsonObject();
                
                Object error = json.get("error");
                
                if(error != null){
                    
                    boolean erro = json.get("error").getAsBoolean();
                    
                    if(!erro){
                        Intent intent = new Intent(ma, TokenLoginActivity.class);
                        intent.putExtra("menssage", json.get("menssage").toString());
                        startActivity(intent);
                    }
                    
                }
            
            }

        }
        
    }
    
}
