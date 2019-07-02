package com.ufersacc.bitniquel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void telaPrincipal(View view)
    {
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);

    }

    public void telaRegistro(View view)
    {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);

    }
}
