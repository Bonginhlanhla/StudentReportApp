package com.example.admin.studentreportapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/21/2017.
 */

public class LactureOparations {

    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            LactureDBHandler.COLUMN_ID,
            LactureDBHandler.COLUMN_FIRST_NAME,
            LactureDBHandler.COLUMN_LAST_NAME,
            LactureDBHandler.COLUMN_SUB_ONE,
            LactureDBHandler.COLUMN_SUB_TWO,
            LactureDBHandler.COLUMN_SUB_THREE,
            LactureDBHandler.COLUMN_SUB_FOUR,
            LactureDBHandler.COLUMN_SUB_FIVE,

    };
    public LactureOparations(Context context){
        dbhandler = new LactureDBHandler(context);
    }

    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database = dbhandler.getWritableDatabase();


    }
    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }

    public Student addEmployee(Student Employee){
        ContentValues values  = new ContentValues();
        values.put(LactureDBHandler.COLUMN_FIRST_NAME,Employee.getFirstname());
        values.put(LactureDBHandler.COLUMN_LAST_NAME,Employee.getLastname());
        values.put(LactureDBHandler.COLUMN_SUB_ONE, Employee.getSubOne());
        values.put(LactureDBHandler.COLUMN_SUB_TWO, Employee.getSubTwo());
        values.put(LactureDBHandler.COLUMN_SUB_THREE, Employee.getSubThree());
        values.put(LactureDBHandler.COLUMN_SUB_FOUR, Employee.getSubFour());
        values.put(LactureDBHandler.COLUMN_SUB_FIVE, Employee.getSubFive());
        long insertid = database.insert(LactureDBHandler.TABLE_EMPLOYEES,null,values);
        Employee.setEmpId(insertid);
        return Employee;

    }
    // Getting single Employee
    public Student getEmployee(long id) {

        Cursor cursor = database.query(LactureDBHandler.TABLE_EMPLOYEES,allColumns,LactureDBHandler.COLUMN_ID + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Student e = new Student(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7),cursor.getString(8));
        // return Employee
        return e;
    }
    public List<Student> getAllEmployees() {

        Cursor cursor = database.query(LactureDBHandler.TABLE_EMPLOYEES, allColumns, null, null, null, null, null);

        List<Student> employees = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Student employee = new Student();
                employee.setEmpId(cursor.getLong(cursor.getColumnIndex(LactureDBHandler.COLUMN_ID)));
                employee.setFirstname(cursor.getString(cursor.getColumnIndex(LactureDBHandler.COLUMN_FIRST_NAME)));
                employee.setLastname(cursor.getString(cursor.getColumnIndex(LactureDBHandler.COLUMN_LAST_NAME)));
                employee.setSubOne(cursor.getInt(cursor.getColumnIndex(LactureDBHandler.COLUMN_SUB_ONE)));
                employee.setSubTwo(cursor.getInt(cursor.getColumnIndex(LactureDBHandler.COLUMN_SUB_TWO)));
                employee.setSubThree(cursor.getInt(cursor.getColumnIndex(LactureDBHandler.COLUMN_SUB_THREE)));
                employee.setSubFour(cursor.getInt(cursor.getColumnIndex(LactureDBHandler.COLUMN_SUB_FOUR)));
                employee.setSubFive(cursor.getInt(cursor.getColumnIndex(LactureDBHandler.COLUMN_SUB_FIVE)));
                employees.add(employee);
            }
        }
        // return All Employees
        return employees;
    }
    public int UpdateAllStudents(Student student)
    {
        ContentValues values = new ContentValues();

        //populate values
        values.put(LactureDBHandler.COLUMN_FIRST_NAME, student.getFirstname());
        values.put(LactureDBHandler.COLUMN_LAST_NAME, student.getLastname());
        values.put(LactureDBHandler.COLUMN_SUB_ONE,   student.getSubOne());
        values.put(LactureDBHandler.COLUMN_SUB_TWO,   student.getSubTwo());
        values.put(LactureDBHandler.COLUMN_SUB_THREE, student.getSubThree());
        values.put(LactureDBHandler.COLUMN_SUB_FOUR, student.getSubFour());
        values.put(LactureDBHandler.COLUMN_SUB_FIVE, student.getSubFive());

        // updating row
        return database.update(LactureDBHandler.TABLE_EMPLOYEES, values,
                LactureDBHandler.COLUMN_ID + "=?",new String[] { String.valueOf(student.getEmpId())});
    }
    // Deleting Employee
    public void removeEmployee(Student employee) {

        database.delete(LactureDBHandler.TABLE_EMPLOYEES, LactureDBHandler.COLUMN_ID + "=" + employee.getEmpId(), null);
    }
}
