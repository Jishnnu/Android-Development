package com.example.ca_2_215;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper_215 extends SQLiteOpenHelper {
    public static final String DB_NAME = "PRESIDENCY_STUDENT_215";
    public static final String TABLE_NAME = "STUDENT_TABLE_215";
    public static final String COL_1 = "REGISTRATION_ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PHYSICS_MARKS";
    public static final String COL_4 = "CHEMISTRY_MARKS";
    public static final String COL_5 = "MATHEMATICS_MARKS";
    public static final String COL_6 = "STATE";

    public DatabaseHelper_215(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(REGISTRATION_ID TEXT PRIMARY KEY, NAME TEXT, PHYSICS_MARKS INTEGER, " +
                "CHEMISTRY_MARKS INTEGER, MATHEMATICS_MARKS INTEGER, STATE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert_215(String reg_id, String name, int phy, int chem, int maths, String state){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, reg_id);
        cv.put(COL_2, name);
        cv.put(COL_3, phy);
        cv.put(COL_4, chem);
        cv.put(COL_5, maths);
        cv.put(COL_6, state);

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
}
