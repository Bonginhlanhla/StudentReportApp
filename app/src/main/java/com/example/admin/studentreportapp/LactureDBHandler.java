package com.example.admin.studentreportapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 8/21/2017.
 */

public class LactureDBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_EMPLOYEES = "student";
    public static final String COLUMN_ID = "studId";
    public static final String COLUMN_FIRST_NAME = "firstname";
    public static final String COLUMN_LAST_NAME = "lastname";
    public static final String COLUMN_SUB_ONE = "subOne";
    public static final String COLUMN_SUB_TWO = "subTwo";
    public static final String COLUMN_SUB_THREE = "subThree";
    public static final String COLUMN_SUB_FOUR = "subFour";
    public static final String COLUMN_SUB_FIVE = "subFive";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_EMPLOYEES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FIRST_NAME + " TEXT, " +
                    COLUMN_LAST_NAME + " TEXT, " +
                    COLUMN_SUB_ONE + " NUMERIC, " +
                    COLUMN_SUB_TWO + " NUMERIC, " +
                    COLUMN_SUB_THREE + " NUMERIC, " +
                    COLUMN_SUB_FOUR + " NUMERIC, " +
                    COLUMN_SUB_FIVE + " NUMERIC " +
                    ")";

    public LactureDBHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EMPLOYEES);
        db.execSQL(TABLE_CREATE);
    }
}
