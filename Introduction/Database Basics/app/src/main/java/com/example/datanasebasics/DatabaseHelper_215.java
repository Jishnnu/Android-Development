package com.example.datanasebasics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper_215 extends SQLiteOpenHelper {
    public static final String DB_NAME = "USERS_215";
    public static final String TABLE_NAME = "USER_TABLE_215";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "PASSWORD";

    public DatabaseHelper_215(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert_215(String un, String pwd){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, un);
        cv.put(COL_3, pwd);

        long result = sql.insert(TABLE_NAME, null, cv);
        if(result == -1){
            return false;
        }
        return true;
    }

    public boolean update_215(String id, String un, String pwd){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, un);
        cv.put(COL_3, pwd);

        long result = sql.update(TABLE_NAME, cv, "ID = ?", new String[]{id});
        if(result == -1){
            return false;
        }
        return true;
    }

    public Integer delete_215(String id){
        SQLiteDatabase sql = this.getWritableDatabase();
        return sql.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

    public Cursor getData_215(){
        SQLiteDatabase sql = this.getWritableDatabase();
        Cursor res = sql.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    public boolean loginCheck_215(String username, String password){
        SQLiteDatabase sql = this.getWritableDatabase();
        Cursor res = sql.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE USERNAME = ? AND PASSWORD = ?", new String[] {username, password});
        if(res.getCount() > 0){
            return true;
        }
        return false;
    }
}
