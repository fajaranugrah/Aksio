package com.example.fajar.aksio1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by fajar on 30/03/2016.
 */
public class senin_guru extends Fragment {

    private EditText txtjam1, txtjam2,txtjam3,txtjam4;
    SQLiteHandler db;
    FragmentActivity c;

    public senin_guru() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //construct a joiner
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.senin_guru, container, false);
        c = (FragmentActivity) getActivity();

        txtjam1 = (EditText) v.findViewById(R.id.editText);
        txtjam2 = (EditText) v.findViewById(R.id.editText3);
        txtjam3 = (EditText) v.findViewById(R.id.editText4);
        txtjam4 = (EditText) v.findViewById(R.id.editText2);

        db = new SQLiteHandler(c);
        HashMap<String, String> user = db.getUserDetailsGuru();
        String jam1 = user.get("jam_1");
        String jam2 = user.get("jam_2");
        String jam3 = user.get("jam_3");
        String jam4 = user.get("jam_4");

        txtjam1.setText(jam1);
        txtjam2.setText(jam2);
        txtjam3.setText(jam3);
        txtjam4.setText(jam4);
        return v;
    }

//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.senin);
//        initUI();
//    }
//
//    private void initUI(){
//        txtjam1 =(EditText) findViewById(R.id.editText);
//        txtjam2 = (EditText) findViewById(R.id.editText3);
//        txtjam3 = (EditText) findViewById(R.id.editText4);
//        txtjam4 = (EditText) findViewById(R.id.editText2);
//
//        // SqLite database handler
//        db = new SQLiteHandler(getApplicationContext());
//
//
//        // Fetching user details from sqlite
//        HashMap<String, String> user = db.getUserDetails();
//
//        String jam1 = user.get("jam1");
//        String jam2 = user.get("jam2");
//        String jam3 = user.get("jam3");
//        String jam4 = user.get("jam4");
//
//        txtjam1.setText(jam1);
//        txtjam2.setText(jam2);
//        txtjam3.setText(jam3);
//        txtjam4.setText(jam4);
//    }
}
