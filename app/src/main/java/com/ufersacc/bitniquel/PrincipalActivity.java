package com.ufersacc.bitniquel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
    }



    void onClickRecebimento(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, RecebimentoActivity.class);
        startActivity(intent);

    }

    void onClickEnvio(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, EnvioActivity.class);
        startActivity(intent);

    }

    void onClickPagamento(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, PagamentoActivity.class);
        startActivity(intent);

    }

    void onClickExtrato(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, ExtratoActivity.class);
        startActivity(intent);

    }
}
