package com.ufersacc.bitniquel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.notbytes.barcode_reader.BarcodeReaderActivity;
import com.ufersacc.bitniquel.connect.ClientConnector;
import com.ufersacc.bitniquel.model.Client;

import java.math.BigDecimal;

public class PrincipalActivity extends AppCompatActivity {

    SharedPreferences mPrefs;
    TextView nomeCliente;
    TextView saldo;
    TextView saldoBrl;
    Button cotacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
        nomeCliente = findViewById(R.id.nomeCliente);
        saldo = findViewById(R.id.saldo);
        saldoBrl = findViewById(R.id.saldoBrl);
        cotacao = findViewById(R.id.cotacao);
        mPrefs = getSharedPreferences("USER_PREF",MODE_PRIVATE);


        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

        Client c = g.fromJson(mPrefs.getString("Client",null),Client.class);


        nomeCliente.setText("Olá, " + c.getNickName());
        BigDecimal s = c.getWallet().getCurrentBalance();

        BigDecimal sBrl = c.getWallet().getCurrentBalanceBrl();
        double ds = s.doubleValue();
        double dsBrl = sBrl.doubleValue();
        saldo.setText(ds + " BTC");
        saldoBrl.setText("R$ " + dsBrl);




        OkHttpHandler handler = new OkHttpHandler();
        handler.execute("");


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

    public void telaGiftCard(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this,GiftCardActivity.class);
        startActivity(intent);
    }

    public class OkHttpHandler extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... params) {

            ClientConnector connector = new ClientConnector();



            return connector.getCotacao();

        }

        @Override
        protected void onPostExecute(String result){



            if(result != null){

                Log.d("Cotacao", result);


                JsonObject json = new JsonParser().parse(result).getAsJsonObject();

                Object error = json.get("error");

                if(error != null){

                    boolean erro = json.get("error").getAsBoolean();

                    if(!erro){
                        cotacao.setText("Cotação atual: R$ " + json.get("value").getAsDouble());





                    }

                }

            }

        }

    }










}
