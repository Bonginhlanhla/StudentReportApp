package com.example.admin.studentreportapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 8/14/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contact_db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLOUMN_ID = "id";
    private static final String COLOUMN_NAME = "name";
    private static final String COLOUMN_EMAIL = "email";
    private static final String COLOUMN_UNAME = "uname";
    private static final String COLOUMN_PASS = "pass";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null  , " +
    "name text not null, email text not null , uname text not null , pass text not null)";

    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db = db;

    }
    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        //Use these two to get the contacts already inserted
        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);

        int count = cursor.getCount();


        //populate table with values
        values.put(COLOUMN_ID, count);
        values.put(COLOUMN_NAME , c.getName());
        values.put(COLOUMN_EMAIL , c.getEmail());
        values.put(COLOUMN_UNAME, c.getUsername());
        values.put(COLOUMN_PASS, c.getPass());

        db.insert(TABLE_NAME , null , values);
        db.close();

    }
    public String searchPass(String uname)
    {
        db = this.getWritableDatabase();
        String query = "select uname , pass from "+ TABLE_NAME ;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";

        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(cursor.getColumnIndex(COLOUMN_UNAME));
                if(a.equals(uname))
                {
                    b = cursor.getString(cursor.getColumnIndex(COLOUMN_PASS));
                    break;
                }


            }while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
