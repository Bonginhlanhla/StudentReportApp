package com.example.admin.studentreportapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class ViewAllStudents extends ListActivity {

    private LactureOparations employeeOps;
    List<Student> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_students);

        employeeOps = new LactureOparations(this);
        employeeOps.open();
        employees = employeeOps.getAllEmployees();
       Student s = employees.get(1);
        Toast.makeText(this, ""+s.getSubFour(), Toast.LENGTH_SHORT).show();
        employeeOps.close();
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, employees);
        setListAdapter(adapter);

    }

}
