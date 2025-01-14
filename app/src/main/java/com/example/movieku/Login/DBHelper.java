package com.example.movieku.Login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String database_name = "db_login";
    public static final String table_name = "table_login";

    public static final String row_id = "_id";
    public static final String row_username = "Username";
    public static final String row_password = "Password";

    public DBHelper(Context context) {
        super(context, database_name, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table_name + "("
                + row_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + row_username + " TEXT, "
                + row_password + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    // Insert Data
    public long insertData(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(table_name, null, values);
        db.close(); // Pastikan untuk menutup database setelah operasi
        return result;
    }

    // Check User
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {row_id};
        String selection = row_username + "=? AND " + row_password + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(table_name, columns, selection, selectionArgs, null, null, null);

        boolean exists = cursor.getCount() > 0;
        cursor.close(); // Pastikan untuk menutup cursor setelah selesai

        db.close(); // Tutup koneksi database
        return exists;
    }
}
