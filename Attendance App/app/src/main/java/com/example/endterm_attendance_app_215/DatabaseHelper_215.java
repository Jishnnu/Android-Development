package com.example.endterm_attendance_app_215;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper_215 extends SQLiteOpenHelper {
    public static final String DB_NAME = "STUDENTS_DATABASE_215";
    public static final String TABLE_NAME = "STUDENTS_TABLE_215";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "ROLL_NUMBER";
    public static final String COL_3 = "ATTENDANCE_PERCENTAGE";
    public static final String COL_4 = "GENDER";

    public DatabaseHelper_215(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(NAME TEXT, ROLL_NUMBER TEXT PRIMARY KEY, ATTENDANCE_PERCENTAGE INTEGER, GENDER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert_215(String name, String roll, int attendance, String gender){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, name);
        cv.put(COL_2, roll);
        cv.put(COL_3, attendance);
        cv.put(COL_4, gender);

        long result = sql.insert(TABLE_NAME, null, cv);
        if(result == -1){
            return false;
        }
        return true;
    }

    public Cursor getData_215(){
        SQLiteDatabase sql = this.getWritableDatabase();
        Cursor res = sql.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    public boolean existAlready_215(String roll_number){
        SQLiteDatabase sql = this.getWritableDatabase();
        Cursor res = sql.rawQuery("SELECT ROLL_NUMBER FROM " + TABLE_NAME + " WHERE ROLL_NUMBER = ?", new String[] {roll_number});
        if(res.getCount() > 0){
            return true;
        }
        return false;
    }

    public Cursor get65Attendance_215(){
        SQLiteDatabase sql = this.getWritableDatabase();
        Cursor res = sql.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ATTENDANCE_PERCENTAGE < ?", new String[]{"65"});
        return res;
    }

    public Cursor get25Attendance_215(){
        SQLiteDatabase sql = this.getWritableDatabase();
        Cursor res = sql.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ATTENDANCE_PERCENTAGE < ?", new String[]{"25"});
        return res;
    }

    public Cursor getMaleStudents_215(String gender){
        SQLiteDatabase sql = this.getWritableDatabase();
        Cursor res = sql.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE GENDER = ?", new String[] {gender});
        return res;
    }
}
