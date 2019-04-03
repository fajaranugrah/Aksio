package com.example.fajar.aksio1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class hal_guru extends Activity {

    private ImageButton btnProfile;
    private ImageButton btnMapel;
    private ImageButton btnRemainder;
    private ImageButton btnInput;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hal_guru);
        initUI();
    }

    private void initUI(){
        btnProfile = (ImageButton) findViewById(R.id.button);
        btnMapel = (ImageButton) findViewById(R.id.button2);
        btnRemainder = (ImageButton) findViewById(R.id.button3);
        //btnInput = (ImageButton) findViewById(R.id.button4);
        final Context context = this;

        btnProfile.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(v == btnProfile){
                    Intent i = new Intent(context, profile_guru.class);
                    startActivity(i);
                }
            }
        });
        btnMapel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == btnMapel) {
                    Intent i = new Intent(context, mapel_guru.class);
                    startActivity(i);
                }
            }
        });
//        btnRemainder.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                if(v == btnRemainder){
//                    Intent i = new Intent(context, remainder.class);
//                    startActivity(i);
//                }
//            }
//        });
//        btnInput.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                if(v == btnInput){
//                    Intent i = new Intent(context, input_nilai.class);
//                    startActivity(i);
//                }
//            }
//        });
    }
}

