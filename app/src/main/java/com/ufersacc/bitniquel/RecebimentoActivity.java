package com.ufersacc.bitniquel;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class RecebimentoActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_recebimento);
        imageView = findViewById(R.id.qrView);
        textView = findViewById(R.id.endView);
        QRGEncoder qrgEncoder = new QRGEncoder(textView.getText().toString(), null, QRGContents.Type.TEXT, 800);
        try {
          Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.v("TAG", e.toString());
        }

    }
}
