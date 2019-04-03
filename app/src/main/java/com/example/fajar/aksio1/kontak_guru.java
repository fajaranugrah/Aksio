package com.example.fajar.aksio1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by fajar on 28/03/2016.
 */
public class kontak_guru extends Activity {

    private SQLiteHandler db;
    private EditText txtguru, txtno_guru;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontak_guru);

        txtguru =(EditText) findViewById(R.id.editText30);
        txtno_guru = (EditText) findViewById(R.id.editText36);
        Button dial=(Button)findViewById(R.id.button11);

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetails();
        String nama = user.get("nama_guru");
        String no_guru = user.get("telepon_guru");

        txtguru.setText(nama);
        txtno_guru.setText(no_guru);

        //ketika menekan tombol call maka akan melakukan dial
        dial.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //number = inputan dari editText
                String toDial = "tel:" + txtno_guru.getText().toString();

                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
            }
        });
    }
}
