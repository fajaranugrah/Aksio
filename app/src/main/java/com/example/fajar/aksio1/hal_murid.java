package com.example.fajar.aksio1;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class hal_murid extends Activity {

    private ImageButton btnProfile;
    private ImageButton btnMapel;
    private ImageButton btnRemainder;
    private ImageButton btnKontak;
    private ImageButton btnGrafik;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hal_murid);
        initUI();
    }

    private void initUI(){
        btnProfile = (ImageButton) findViewById(R.id.button);
        btnMapel = (ImageButton) findViewById(R.id.button2);
        btnRemainder = (ImageButton) findViewById(R.id.button3);
        btnKontak = (ImageButton) findViewById(R.id.button5);
        //btnGrafik = (ImageButton) findViewById(R.id.button4);
        final Context context = this;

        btnProfile.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(v == btnProfile){
                    Intent i = new Intent(context, profile_murid.class);
                    startActivity(i);
                }
            }
        });
        btnMapel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == btnMapel) {
                    Intent i = new Intent(context, mapel.class);
                    startActivity(i);
                }
            }
        });
        btnRemainder.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(v == btnRemainder){
                    Intent i = new Intent(context, regis.class);
                    startActivity(i);
                }
            }
        });
        btnKontak.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(v == btnKontak){
                    Intent i = new Intent(context, kontak_guru.class);
                    startActivity(i);
                }
            }
        });
//        btnGrafik.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                if(v == btnGrafik){
//                    Intent i = new Intent(context, grafik.class);
//                    startActivity(i);
//                }
//            }
//        });
    }
}
