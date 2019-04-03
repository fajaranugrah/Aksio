package com.example.fajar.aksio1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by fajar on 28/03/2016.
 */
public class grafik extends Activity {

    private Button btnmtk;
    private Button btnign;
    private Button btnidn;
    private Button btnipa;
    private Button btnips;
    private Button btnagm;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafik);
        initUI();
    }

    private void initUI(){
        btnmtk = (Button) findViewById(R.id.button12);
        btnign = (Button) findViewById(R.id.button15);
        btnipa = (Button) findViewById(R.id.button13);
        btnips = (Button) findViewById(R.id.button14);
        btnagm = (Button) findViewById(R.id.button17);
        btnidn = (Button) findViewById(R.id.button16);
        final Context context = this;

        btnmtk.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(v == btnmtk){
                    Intent i = new Intent(context, nilai_mtk.class);
                    startActivity(i);
                }
            }
        });
        btnign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == btnign) {
                    Intent i = new Intent(context, nilai_bign.class);
                    startActivity(i);
                }
            }
        });
        btnipa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == btnipa) {
                    Intent i = new Intent(context, nilai_ipa.class);
                    startActivity(i);
                }
            }
        });
        btnips.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == btnips) {
                    Intent i = new Intent(context, nilai_ips.class);
                    startActivity(i);
                }
            }
        });
        btnagm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == btnagm) {
                    Intent i = new Intent(context, nilai_agama.class);
                    startActivity(i);
                }
            }
        });
        btnidn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == btnidn) {
                    Intent i = new Intent(context, nilai_idn.class);
                    startActivity(i);
                }
            }
        });
    }
}
