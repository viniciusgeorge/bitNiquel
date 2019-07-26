package com.ufersacc.bitniquel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.notbytes.barcode_reader.BarcodeReaderActivity;
import com.ufersacc.bitniquel.model.Client;

public class PrincipalActivity extends AppCompatActivity {

    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        mPrefs = getSharedPreferences("USER_PREF",MODE_PRIVATE);
        

        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

        Client c = g.fromJson(mPrefs.getString("Client",null),Client.class);
        Log.d("TesteNome",c.getNickName());
    }

    public void telaRecebimento(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, RecebimentoActivity.class);
        startActivity(intent);
    }

    public void telaEnvio(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, EnvioActivity.class);
        startActivity(intent);
    }

    public void telaPagamento(View view)
    {
        Intent launchIntent = BarcodeReaderActivity.getLaunchIntent(this, true, false);
        startActivityForResult(launchIntent, 1208);


        //Intent intent = new Intent(PrincipalActivity.this, PagamentoActivity.class);
        //startActivity(intent);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != PrincipalActivity.RESULT_OK) {
            Toast.makeText(this, "error in  scanning", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == 1208 && data != null) {
            Barcode barcode = data.getParcelableExtra(BarcodeReaderActivity.KEY_CAPTURED_BARCODE);
            Toast.makeText(this, barcode.rawValue, Toast.LENGTH_SHORT).show();
        }
    }

    public void telaExtrato(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, ExtratoActivity.class);
        startActivity(intent);
    }
    
}
