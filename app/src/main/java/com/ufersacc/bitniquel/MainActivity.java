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

    void onClickPrincipal(View view)
    {
        Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
        startActivity(intent);

    }

    void onClickRegistro(View view)
    {
        Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(intent);

    }
}
