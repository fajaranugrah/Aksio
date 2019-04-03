package com.example.fajar.aksio1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by fajar on 30/03/2016.
 */
public class profile_guru extends Activity {

    private SQLiteHandler db;
    private SessionManager session;
    private EditText txtnip, txtnama, txtgender, txtalamat, txttelepon, txtid_kelas, txttanggal;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_guru);
        initUI();
    }

    private void initUI(){
        txtnip = (EditText) findViewById(R.id.editText21);
        txtnama = (EditText) findViewById(R.id.editText22);
        txtgender = (EditText) findViewById(R.id.editText33);
        txtid_kelas = (EditText) findViewById(R.id.editText23);
        txttanggal = (EditText) findViewById(R.id.editText24);
        txtalamat = (EditText) findViewById(R.id.editText25);
        txttelepon = (EditText) findViewById(R.id.editText26);

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());


        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetailsGuru();
        String NIP = user.get("nip");
        String nama = user.get("nama_guru");
        String gender = user.get("gender");
        String tgl = user.get("tanggal");
        String alamat = user.get("alamat");
        String tlp = user.get("telepon_guru");
        String id_kelas = user.get("id_kelas");

        txtnip.setText(NIP);
        txtnama.setText(nama);
        txtgender.setText(gender);
        txtid_kelas.setText(id_kelas);
        txttanggal.setText(tgl);
        txttelepon.setText(tlp);
        txtalamat.setText(alamat);
    }
}
