package com.example.fajar.aksio1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login_form extends AppCompatActivity implements View.OnClickListener{

    public static final String LOGIN_URL = "http://aplikasiakur.hol.es/login.php";

    public static final String KEY_NIS="NIS";
    public static final String KEY_PASSWORD="password";
    private EditText editUsername, editPassword;
    private Button btnLogin;
    private TextView txtStatus;
    String username, password, user;
    private SessionManager session;
    private SQLiteHandler db;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        initUI();

        // SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Session manager
        session = new SessionManager(getApplicationContext());
    }

    private void initUI() {
        editUsername = (EditText) findViewById(R.id.username);
        editUsername.getText();
        editPassword = (EditText) findViewById(R.id.password);
        editPassword.getText();
        btnLogin = (Button) findViewById(R.id.SignIn);
        btnLogin.setOnClickListener(this);


    }

    private void userLogin() {
        username = editUsername.getText().toString().trim();
        password = editPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jobj=null;
                        try {
                            jobj=new JSONObject(response);
                            Log.e("tes", String.valueOf(jobj.getBoolean("eror")));

                            if(jobj.getBoolean("eror")){
                                Toast.makeText(getApplication(),jobj.getString("message"),Toast.LENGTH_LONG).show();
                                alert.showAlertDialog(login_form.this, "Registration Error!", "Please enter your details", false);
                            }else{
                                JSONArray json=new JSONArray(jobj.getString("user"));
                                //parseData(json);
                                String users=jobj.getString("users");
                                if(users.equals("guru")){
                                    //session.setLogin(true);
                                    parseDataGuru(json);
                                    Intent intent = new Intent(login_form.this, hal_guru.class);
                                    intent.putExtra(KEY_NIS, username);
                                    startActivity(intent);

                                }else if(users.equals("siswa")){
                                    //session.setLogin(true);
                                    parseDataSiswa(json);
                                    Intent intent = new Intent(login_form.this, hal_murid.class);
                                    intent.putExtra(KEY_NIS, username);
                                    startActivity(intent);
                                }
                                //openProfile(users);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login_form.this,error.toString(), Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_NIS,username);
                map.put(KEY_PASSWORD,password);

                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void parseDataSiswa(JSONArray json) {
        JSONObject jobj=null;
        for (int i=0;i<json.length();i++){
            try {
                session.setLogin(true);
                jobj=json.getJSONObject(i);
                db.addUserSiswa(jobj.getString("nis"),
                        jobj.getString("nama"),
                        jobj.getString("gender"),
                        jobj.getString("tanggal"),
                        jobj.getString("alamat"),
                        jobj.getString("ortu"),
                        jobj.getString("telepon"),
                        jobj.getString("id_kelas"),
                        jobj.getString("telepon_guru"),
                        jobj.getString("jam_1"),
                        jobj.getString("jam_2"),
                        jobj.getString("jam_3"),
                        jobj.getString("jam_4"),
                        jobj.getString("nama_guru"),
                        jobj.getString("jam_5"),
                        jobj.getString("jam_6"),
                        jobj.getString("jam_7"),
                        jobj.getString("jam_8"),
                        jobj.getString("jam_9"),
                        jobj.getString("jam_10"),
                        jobj.getString("jam_11"),
                        jobj.getString("jam_12"),
                        jobj.getString("jam_13"),
                        jobj.getString("jam_14"),
                        jobj.getString("jam_15"),
                        jobj.getString("jam_16"),
                        jobj.getString("jam_17"),
                        jobj.getString("jam_18"),
                        jobj.getString("jam_19"),
                        jobj.getString("jam_20"));

                Intent intent = new Intent(login_form.this,
                        hal_murid.class);
                startActivity(intent);
                finish();
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
    }

    private void parseDataGuru(JSONArray json) {
        JSONObject jobj=null;
        for (int i=0;i<json.length();i++){
            try {
                session.setLogin(true);
                jobj=json.getJSONObject(i);
                db.addUserGuru(jobj.getString("nip"),
                        jobj.getString("nama_guru"),
                        jobj.getString("gender"),
                        jobj.getString("tanggal"),
                        jobj.getString("alamat"),
                        jobj.getString("telepon_guru"),
                        jobj.getString("id_kelas"),
                        jobj.getString("jam_1"),
                        jobj.getString("jam_2"),
                        jobj.getString("jam_3"),
                        jobj.getString("jam_4"),
                        jobj.getString("jam_5"),
                        jobj.getString("jam_6"),
                        jobj.getString("jam_7"),
                        jobj.getString("jam_8"),
                        jobj.getString("jam_9"),
                        jobj.getString("jam_10"),
                        jobj.getString("jam_11"),
                        jobj.getString("jam_12"),
                        jobj.getString("jam_13"),
                        jobj.getString("jam_14"),
                        jobj.getString("jam_15"),
                        jobj.getString("jam_16"),
                        jobj.getString("jam_17"),
                        jobj.getString("jam_18"),
                        jobj.getString("jam_19"),
                        jobj.getString("jam_20"));

                Intent intent = new Intent(login_form.this,
                        hal_guru.class);
                startActivity(intent);
                finish();
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
    }

    //private void openProfile(String users){
    //    if (users.equals("siswa")){
    //        session.setLogin(true);
    //        Intent intent = new Intent(this, hal_murid.class);
    //        intent.putExtra(KEY_NIS, username);
    //        startActivity(intent);

    //    }else if (users.equals("guru")){
    //        session.setLogin(true);
    //        Intent intent = new Intent(this, hal_guru.class);
    //        intent.putExtra(KEY_NIS, username);
    //        startActivity(intent);
    //    }

    //}

    @Override
    public void onClick(View v) {
        userLogin();
    }
}

