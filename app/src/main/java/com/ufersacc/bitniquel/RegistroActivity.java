package com.ufersacc.bitniquel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.ufersacc.bitniquel.connect.Connector;

public class RegistroActivity extends AppCompatActivity {


    EditText etNomeCompleto;
    EditText etNomeSocial;
    EditText etNascimento;
    EditText etEmail;
    EditText etSenha;
    EditText etTelefone;
    EditText etCep;


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
    }





    public void registrar(View view) {

        String nomeCompleto = etNomeCompleto.getText().toString();
        String nomeSocial = etNomeSocial.getText().toString();
        String nascimento = etNascimento.getText().toString();
        String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();
        String telefone = etTelefone.getText().toString();
        String cep = etCep.getText().toString();

        Connector connector = new Connector();
        connector.signup(nomeCompleto,nomeSocial,nascimento,email,senha,"55","84",telefone,cep);


    }
}
