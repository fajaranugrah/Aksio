package com.example.fajar.aksio1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.fajar.aksio1.CommonUtilities.SERVER_URL_INPUT;

/**
 * Created by fajar on 30/03/2016.
 */
public class input_nilai extends Activity{

    AlertDialogManager alert = new AlertDialogManager();

    EditText nis, mtk, ipa, ips, indo, ing, agm;
    Button submit;
    ConnectionDetector cd;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_nilai);
        initUi();
    }

    private void initUi(){

        cd = new ConnectionDetector(getApplicationContext());

        nis = (EditText)findViewById(R.id.editText40);
        mtk = (EditText)findViewById(R.id.editText27);
        ipa = (EditText)findViewById(R.id.editText28);
        ips = (EditText)findViewById(R.id.editText29);
        indo = (EditText)findViewById(R.id.editText34);
        ing = (EditText)findViewById(R.id.editText35);
        agm = (EditText)findViewById(R.id.editText37);

        // Check if GCM configuration is set
        if (SERVER_URL_INPUT == null || SERVER_URL_INPUT.length() == 0) {
            // GCM sernder id / server url is missing
            alert.showAlertDialog(input_nilai.this, "Configuration Error!",
                    "Please set your Server URL ", false);
            // stop executing code by return
            return;
        }

        submit = (Button)findViewById(R.id.button8);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtnis = nis.getText().toString();
                String txtmtk = mtk.getText().toString();
                String txtipa = ipa.getText().toString();
                String txtips = ips.getText().toString();
                String txtindo = indo.getText().toString();
                String txting = ing.getText().toString();
                String txtagm = agm.getText().toString();

                if(txtnis.trim().length() > 0 && txtmtk.trim().length() > 0&& txtipa.trim().length() > 0&& txtips.trim().length() > 0
                        && txtindo.trim().length() > 0&& txting.trim().length() > 0&& txtagm.trim().length() > 0){
                    // Launch Main Activity
                    Intent i = new Intent(getApplicationContext(), input_nilai.class);

                    // Registering user on our server
                    // Sending registraiton details to MainActivity
                    i.putExtra("nis", txtnis);
                    i.putExtra("mtk", txtmtk);
                    i.putExtra("ipa", txtipa);
                    i.putExtra("ips", txtips);
                    i.putExtra("indo", txtindo);
                    i.putExtra("ing", txting);
                    i.putExtra("agm", txtagm);
                    startActivity(i);
                    finish();
                    alert.showAlertDialog(input_nilai.this, "Informasi", "Terima kasih anda Sudah Mengirim Nilai", true);
                }else{
                    // user doen't filled that data
                    // ask him to fill the form
                    alert.showAlertDialog(input_nilai.this, "Informasi", "Nilai belum Lengkap", false);
                }
            }
        });
    }
}
