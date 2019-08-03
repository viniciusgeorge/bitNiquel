package com.ufersacc.bitniquel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.WriterException;
import com.ufersacc.bitniquel.model.Client;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class RecebimentoActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    SharedPreferences mPrefs;
    String endereco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_recebimento);
        imageView = findViewById(R.id.qrView);
        textView = findViewById(R.id.endView);

        mPrefs = getSharedPreferences("USER_PREF",MODE_PRIVATE);


        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

        Client c = g.fromJson(mPrefs.getString("Client",null),Client.class);
        endereco = c.getWallet().getBitcoinAddress();
        textView.setText(endereco);



        QRGEncoder qrgEncoder = new QRGEncoder(textView.getText().toString(), null, QRGContents.Type.TEXT, 800);
        try {
          Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.v("TAG", e.toString());
        }

    }

    public void voltar(View view) {
        super.onBackPressed();
    }

    public void compartilhar(View view) {

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = endereco;
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Compartilhar");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Compartilhar por"));

    }
}
