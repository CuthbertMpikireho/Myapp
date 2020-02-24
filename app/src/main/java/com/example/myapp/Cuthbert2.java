package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Cuthbert2 extends AppCompatActivity {
    TextView c_program;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuthbert2);
        c_program=findViewById(R.id.browser);
        String  txt ="";

        try {
            InputStream inputStream = getAssets().open("main.c");
            int size = inputStream.available();
            byte[]buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            txt=new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        c_program.setText((CharSequence)txt);

    }
}
