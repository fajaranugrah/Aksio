package com.example.fajar.aksio1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.util.HashMap;


public class profile_murid extends AppCompatActivity {

    private EditText txtnis, txtnama,txtkelas,txtgender,txttgl,txtalamat,txtortu,txttlp;
    private SQLiteHandler db;
    private SessionManager session;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_murid);
        initUI();
    }

    private void initUI(){
        txtnis = (EditText) findViewById(R.id.editText21);
        txtnama = (EditText) findViewById(R.id.editText22);
        txtkelas = (EditText) findViewById(R.id.editText23);
        txtgender = (EditText) findViewById(R.id.editText31);
        txttgl = (EditText) findViewById(R.id.editText24);
        txtalamat = (EditText) findViewById(R.id.editText25);
        txtortu = (EditText) findViewById(R.id.editText26);
        txttlp = (EditText) findViewById(R.id.editText32);

        //db=new SQLiteHandler(this);

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());


        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetails();

        String NIS = user.get("nis");
        String name = user.get("nama");
        String gender = user.get("gender");
        String tgl = user.get("tanggal");
        String alamet = user.get("alamat");
        String ortu = user.get("ortu");
        String tlp = user.get("telepon");
        String id_kelas = user.get("id_kelas");

        // Displaying the user details on the screen
        txtnis.setText(NIS);
        txtnama.setText(name);
        txtkelas.setText(id_kelas);
        txtgender.setText(gender);
        txttgl.setText(tgl);
        txtortu.setText(ortu);
        txttlp.setText(tlp);
        txtalamat.setText(alamet);

    }
}
