package com.leynnnnnn.skid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "appuserslist.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE appusers (username TEXT UNIQUE, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS appusers");
    }

    public Boolean addUser(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);

        long result = db.insert("appusers", null, contentValues);
        return result > 0;
    }

    public Cursor getUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM appusers", null);
    }

    public Cursor doesExist(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM appusers WHERE username = ?";
        String[] selectionArgs = {username};
        return db.rawQuery(query, selectionArgs);
    }
}
