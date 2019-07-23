package com.ufersacc.bitniquel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.notbytes.barcode_reader.BarcodeReaderActivity;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
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
