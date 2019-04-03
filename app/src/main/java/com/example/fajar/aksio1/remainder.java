package com.example.fajar.aksio1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by fajar on 30/03/2016.
 */
public class remainder extends Activity {
    EditText txttopik, txtisi;
    Button btnnotif;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remainder);
        initUI();
    }

    private void initUI(){
        txttopik = (EditText)findViewById(R.id.editText38);
        txtisi = (EditText)findViewById(R.id.editText39);

        btnnotif = (Button) findViewById(R.id.button6);

    }
}