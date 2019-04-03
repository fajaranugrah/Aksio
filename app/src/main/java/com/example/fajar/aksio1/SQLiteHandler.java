package com.example.fajar.aksio1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by fajar on 19/04/2016.
 */
public class SQLiteHandler extends SQLiteOpenHelper{
    private static final String TAG = SQLiteHandler.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "akur1";

    // Login table name
    private static final String TABLE_USER = "murids";
    private static final String TABLE_GURU = "guru";

    // Login Table Columns names
    private static final String KEY_NIS = "nis";
    private static final String KEY_NIP = "nip";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_NAMA_GURU = "nama_guru";
    private static final String KEY_ID_KELAS = "id_kelas";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_TANGGAL = "tanggal";
    private static final String KEY_ORTU = "ortu";
    private static final String KEY_TELEPON = "telepon";
    private static final String KEY_TELEPON_GURU = "telepon_guru";
    private static final String KEY_ALAMAT = "alamat";
    private static final String KEY_JAM_1 = "jam_1";
    private static final String KEY_JAM_2 = "jam_2";
    private static final String KEY_JAM_3 = "jam_3";
    private static final String KEY_JAM_4 = "jam_4";
    private static final String KEY_JAM_5 = "jam_5";
    private static final String KEY_JAM_6 = "jam_6";
    private static final String KEY_JAM_7 = "jam_7";
    private static final String KEY_JAM_8 = "jam_8";
    private static final String KEY_JAM_9 = "jam_9";
    private static final String KEY_JAM_10 = "jam_10";
    private static final String KEY_JAM_11 = "jam_11";
    private static final String KEY_JAM_12 = "jam_12";
    private static final String KEY_JAM_13 = "jam_13";
    private static final String KEY_JAM_14 = "jam_14";
    private static final String KEY_JAM_15 = "jam_15";
    private static final String KEY_JAM_16 = "jam_16";
    private static final String KEY_JAM_17 = "jam_17";
    private static final String KEY_JAM_18 = "jam_18";
    private static final String KEY_JAM_19 = "jam_19";
    private static final String KEY_JAM_20 = "jam_20";
    private static final String KEY_NILAI_MTK = "nilai_mtk";
    private static final String KEY_NILAI_IPS = "nilai_ips";
    private static final String KEY_NILAI_ING = "nilai_ing";
    private static final String KEY_NILAI_INDO = "nilai_indo";
    private static final String KEY_NILAI_IPA = "nilai_ipa";
    private static final String KEY_NILAI_AGM = "nilai_agm";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_NIS + " INTEGER PRIMARY KEY UNIQUE," + KEY_NAMA + " TEXT,"
                + KEY_GENDER + " TEXT," + KEY_TANGGAL + " TEXT,"
                + KEY_ALAMAT + " TEXT," + KEY_ORTU + " TEXT," + KEY_TELEPON + " TEXT," + KEY_ID_KELAS +
                " TEXT," + KEY_TELEPON_GURU + " TEXT," + KEY_JAM_1 + " TEXT," + KEY_JAM_2 + " TEXT,"
                + KEY_JAM_3 + " TEXT," + KEY_JAM_4 + " TEXT," + KEY_NAMA_GURU + " TEXT," + KEY_JAM_5 + " TEXT,"
                + KEY_JAM_6 + " TEXT," + KEY_JAM_7 + " TEXT," + KEY_JAM_8 + " TEXT," + KEY_JAM_9 + " TEXT," + KEY_JAM_10 + " TEXT,"
                + KEY_JAM_11 + " TEXT," + KEY_JAM_12 + " TEXT," + KEY_JAM_13 + " TEXT," + KEY_JAM_14 + " TEXT," + KEY_JAM_15 + " TEXT," + KEY_JAM_16 +
                " TEXT," + KEY_JAM_17 + " TEXT," + KEY_JAM_18 + " TEXT," + KEY_JAM_19 + " TEXT," + KEY_JAM_20 + " TEXT" +")";
        db.execSQL(CREATE_LOGIN_TABLE);

        String CREATE_LOGIN_TABLE_GURU = "CREATE TABLE " + TABLE_GURU + "("
                + KEY_NIP + " INTEGER PRIMARY KEY UNIQUE," + KEY_NAMA_GURU + " TEXT,"
                + KEY_GENDER + " TEXT," + KEY_TANGGAL + " TEXT,"
                + KEY_ALAMAT + " TEXT," + KEY_TELEPON_GURU + " TEXT," + KEY_ID_KELAS + " TEXT," + KEY_JAM_1 + " TEXT," + KEY_JAM_2 + " TEXT,"
                + KEY_JAM_3 + " TEXT," + KEY_JAM_4 + " TEXT," + KEY_JAM_5 + " TEXT,"+ KEY_JAM_6 + " TEXT," + KEY_JAM_7 + " TEXT,"
                + KEY_JAM_8 + " TEXT," + KEY_JAM_9 + " TEXT," + KEY_JAM_10 + " TEXT," + KEY_JAM_11 + " TEXT," + KEY_JAM_12 + " TEXT,"
                + KEY_JAM_13 + " TEXT," + KEY_JAM_14 + " TEXT," + KEY_JAM_15 + " TEXT," + KEY_JAM_16 +
                " TEXT," + KEY_JAM_17 + " TEXT," + KEY_JAM_18 + " TEXT," + KEY_JAM_19 + " TEXT," + KEY_JAM_20 + " TEXT" +")";
        db.execSQL(CREATE_LOGIN_TABLE_GURU);

        Log.d(TAG, "Database tables created");
    }


    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GURU);

        // Create tables again
        onCreate(db);
    }

    /**
     * Storing user details in database
     * */
    public void addUserSiswa(String nis, String nama, String gender, String tanggal,
                             String alamat, String ortu, String telepon, String id_kelas, String telepon_guru,
                             String jam_1, String jam_2, String jam_3, String jam_4, String nama_guru, String jam_5, String jam_6, String jam_7,
                             String jam_8, String jam_9, String jam_10, String jam_11, String jam_12, String jam_13, String jam_14, String jam_15, String jam_16,
                             String jam_17, String jam_18, String jam_19, String jam_20) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NIS, nis);
        values.put(KEY_NAMA, nama);
        values.put(KEY_GENDER, gender);
        values.put(KEY_TANGGAL, tanggal);
        values.put(KEY_ALAMAT, alamat);
        values.put(KEY_ORTU, ortu);
        values.put(KEY_TELEPON, telepon);
        values.put(KEY_ID_KELAS, id_kelas);
        values.put(KEY_TELEPON_GURU, telepon_guru);
        values.put(KEY_JAM_1, jam_1);
        values.put(KEY_JAM_2, jam_2);
        values.put(KEY_JAM_3, jam_3);
        values.put(KEY_JAM_4, jam_4);
        values.put(KEY_NAMA_GURU, nama_guru);
        values.put(KEY_JAM_5, jam_5);
        values.put(KEY_JAM_6, jam_6);
        values.put(KEY_JAM_7, jam_7);
        values.put(KEY_JAM_8, jam_8);
        values.put(KEY_JAM_9, jam_9);
        values.put(KEY_JAM_10, jam_10);
        values.put(KEY_JAM_11, jam_11);
        values.put(KEY_JAM_12, jam_12);
        values.put(KEY_JAM_13, jam_13);
        values.put(KEY_JAM_14, jam_14);
        values.put(KEY_JAM_15, jam_15);
        values.put(KEY_JAM_16, jam_16);
        values.put(KEY_JAM_17, jam_17);
        values.put(KEY_JAM_18, jam_18);
        values.put(KEY_JAM_19, jam_19);
        values.put(KEY_JAM_20, jam_20);




        // Inserting Row
        long id = db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

    public void addUserGuru(String nip, String nama_guru, String gender, String tanggal, String alamat, String telepon_guru, String id_kelas,
                            String jam_1, String jam_2, String jam_3, String jam_4, String jam_5, String jam_6, String jam_7, String jam_8,
                            String jam_9, String jam_10, String jam_11, String jam_12, String jam_13, String jam_14, String jam_15,
                            String jam_16, String jam_17, String jam_18, String jam_19, String jam_20) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NIP, nip);
        values.put(KEY_NAMA_GURU, nama_guru);
        values.put(KEY_GENDER, gender);
        values.put(KEY_TANGGAL, tanggal);
        values.put(KEY_ALAMAT, alamat);
        values.put(KEY_TELEPON_GURU, telepon_guru);
        values.put(KEY_ID_KELAS, id_kelas);
        values.put(KEY_JAM_1, jam_1);
        values.put(KEY_JAM_2, jam_2);
        values.put(KEY_JAM_3, jam_3);
        values.put(KEY_JAM_4, jam_4);
        values.put(KEY_JAM_5, jam_5);
        values.put(KEY_JAM_6, jam_6);
        values.put(KEY_JAM_7, jam_7);
        values.put(KEY_JAM_8, jam_8);
        values.put(KEY_JAM_9, jam_9);
        values.put(KEY_JAM_10, jam_10);
        values.put(KEY_JAM_11, jam_11);
        values.put(KEY_JAM_12, jam_12);
        values.put(KEY_JAM_13, jam_13);
        values.put(KEY_JAM_14, jam_14);
        values.put(KEY_JAM_15, jam_15);
        values.put(KEY_JAM_16, jam_16);
        values.put(KEY_JAM_17, jam_17);
        values.put(KEY_JAM_18, jam_18);
        values.put(KEY_JAM_19, jam_19);
        values.put(KEY_JAM_20, jam_20);

        // Inserting Row
        long id = db.insert(TABLE_GURU, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

    /**
     * Getting user data from database
     * */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("nis", cursor.getString(0));
            user.put("nama", cursor.getString(1));
            user.put("gender", cursor.getString(2));
            user.put("tanggal", cursor.getString(3));
            user.put("alamat", cursor.getString(4));
            user.put("ortu", cursor.getString(5));
            user.put("telepon", cursor.getString(6));
            user.put("id_kelas", cursor.getString(7));
            user.put("telepon_guru", cursor.getString(8));
            user.put("jam_1", cursor.getString(9));
            user.put("jam_2", cursor.getString(10));
            user.put("jam_3", cursor.getString(11));
            user.put("jam_4", cursor.getString(12));
            user.put("nama_guru", cursor.getString(13));
            user.put("jam_5", cursor.getString(14));
            user.put("jam_6", cursor.getString(15));
            user.put("jam_7", cursor.getString(16));
            user.put("jam_8", cursor.getString(17));
            user.put("jam_9", cursor.getString(18));
            user.put("jam_10", cursor.getString(19));
            user.put("jam_11", cursor.getString(20));
            user.put("jam_12", cursor.getString(21));
            user.put("jam_13", cursor.getString(22));
            user.put("jam_14", cursor.getString(23));
            user.put("jam_15", cursor.getString(24));
            user.put("jam_16", cursor.getString(25));
            user.put("jam_17", cursor.getString(26));
            user.put("jam_18", cursor.getString(27));
            user.put("jam_19", cursor.getString(28));
            user.put("jam_20", cursor.getString(29));



        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }


    public HashMap<String, String> getUserDetailsGuru() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_GURU;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("nip", cursor.getString(0));
            user.put("nama_guru", cursor.getString(1));
            user.put("gender", cursor.getString(2));
            user.put("tanggal", cursor.getString(3));
            user.put("alamat", cursor.getString(4));
            user.put("telepon_guru", cursor.getString(5));
            user.put("id_kelas", cursor.getString(6));
            user.put("jam_1", cursor.getString(7));
            user.put("jam_2", cursor.getString(8));
            user.put("jam_3", cursor.getString(9));
            user.put("jam_4", cursor.getString(10));
            user.put("jam_5", cursor.getString(11));
            user.put("jam_6", cursor.getString(12));
            user.put("jam_7", cursor.getString(13));
            user.put("jam_8", cursor.getString(14));
            user.put("jam_9", cursor.getString(15));
            user.put("jam_10", cursor.getString(16));
            user.put("jam_11", cursor.getString(17));
            user.put("jam_12", cursor.getString(18));
            user.put("jam_13", cursor.getString(19));
            user.put("jam_14", cursor.getString(20));
            user.put("jam_15", cursor.getString(21));
            user.put("jam_16", cursor.getString(22));
            user.put("jam_17", cursor.getString(23));
            user.put("jam_18", cursor.getString(24));
            user.put("jam_19", cursor.getString(25));
            user.put("jam_20", cursor.getString(26));

        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }

    /**
     * Re crate database Delete all tables and create them again
     * */
    public void deleteUsersSiswa() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_USER, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }

    public void deleteUsersGuru() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_GURU, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }
}
