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
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText etNomeCompleto;
    EditText etNomeSocial;
    EditText etNascimento;
    EditText etEmail;
    EditText etSenha;
    EditText etTelefone;
    EditText etCep;
    
    RegistroActivity rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_registro);

        etNomeCompleto = findViewById(R.id.nomeCompleto);
        etNomeSocial = findViewById(R.id.nomeSocial);
        etNascimento = findViewById(R.id.nascimento);
        etEmail = findViewById(R.id.email);
        etSenha = findViewById(R.id.senha);
        etTelefone = findViewById(R.id.telefone);
        etCep = findViewById(R.id.cep);
        
        rg = this;
    }

    public void registrar(View view) {
        
        OkHttpHandler handler = new OkHttpHandler();
        handler.execute("");

    }
    
    public class OkHttpHandler extends AsyncTask<String,String,String>{
                
        @Override
        protected String doInBackground(String... params) {
            
            ClientConnector connector = new ClientConnector();
            
            String nomeCompleto = etNomeCompleto.getText().toString();
            String nomeSocial = etNomeSocial.getText().toString();
            String nascimento = etNascimento.getText().toString();
            String email = etEmail.getText().toString();
            String senha = etSenha.getText().toString();
            String telefone = etTelefone.getText().toString();
            String cep = etCep.getText().toString();
            
            return connector.signup(nomeCompleto,nomeSocial,nascimento,email,senha,"55","84",telefone,cep);
        } 
        
        @Override
        protected void onPostExecute(String result){
            
            Log.d("RegistroActivity", "onPostExecute");

            Intent intent = new Intent(rg, MainActivity.class);
            startActivity(intent);
            
            if(result != null){
                
                Log.d("RegistroActivity", result);
                
                JsonObject json = new JsonParser().parse(result).getAsJsonObject();
                
                Object error = json.get("error");
                
                if(error != null){
                    
                    boolean erro = json.get("error").getAsBoolean();
                    
                    if(!erro){
                        Intent intent2 = new Intent(rg, MainActivity.class);
                        startActivity(intent2);
                    }
                    
                }
            
            }

        }
        
    }
    
}
