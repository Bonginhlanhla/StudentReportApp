package com.example.admin.studentreportapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddUpdateStudent extends AppCompatActivity {

    private static final String EXTRA_EMP_ID = "com.androidtutorialpoint.empId";
    private static final String EXTRA_ADD_UPDATE = "com.androidtutorialpoint.add_update";
    private static final String DIALOG_DATE = "DialogDate";
    private RadioButton maleRadioButton,femaleRadioButton;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText subOne;
    private EditText subTwo;
    private EditText subThree;
    private EditText subFour;
    private EditText subFive;
    private Button addUpdateButton;
    private Student newEmployee;
    private Student oldEmployee;
    private String mode;
    private long empId;
    private LactureOparations employeeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update_student);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        newEmployee = new Student();
        oldEmployee = new Student();
        firstNameEditText = (EditText)findViewById(R.id.editfirstname);
        lastNameEditText = (EditText)findViewById(R.id.editlastname);
        subOne = (EditText)findViewById(R.id.editsubOne);
        subTwo = (EditText)findViewById(R.id.editSubTwo);
        subThree = (EditText) findViewById(R.id.editSubThree);
        subFour = (EditText)findViewById(R.id.editSubfour);
        subFive = (EditText)findViewById(R.id.editSubFive);

        addUpdateButton = (Button)findViewById(R.id.buttonAdd);
        employeeData = new LactureOparations(this);
        employeeData.open();


        mode = getIntent().getStringExtra(EXTRA_ADD_UPDATE);
        if(mode.equals("Update")){

            addUpdateButton.setText("Update Employee");
            empId = getIntent().getLongExtra(EXTRA_EMP_ID,0);

            initializeEmployee(empId);

        }
        addUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mode.equals("Add")) {
                    newEmployee.setFirstname(firstNameEditText.getText().toString());
                    newEmployee.setLastname(lastNameEditText.getText().toString());
                    newEmployee.setSubOne(Integer.parseInt(subOne.getText().toString()));
                    newEmployee.setSubTwo(Integer.parseInt(subTwo.getText().toString()));
                    newEmployee.setSubThree(Integer.parseInt(subThree.getText().toString()));
                    newEmployee.setSubFour(Integer.parseInt(subFour.getText().toString()));
                    newEmployee.setSubFive(Integer.parseInt(subFive.getText().toString()));

                    employeeData.addEmployee(newEmployee);
                    Toast t = Toast.makeText(AddUpdateStudent.this, "Employee "+ newEmployee.getFirstname() + "has been added successfully !", Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(AddUpdateStudent.this,MenuActivity.class);
                    startActivity(i);
                }else {
                    oldEmployee.setFirstname(firstNameEditText.getText().toString());
                    oldEmployee.setLastname(lastNameEditText.getText().toString());
                    oldEmployee.setSubOne(Integer.parseInt(subOne.getText().toString()));
                    oldEmployee.setSubTwo(Integer.parseInt(subTwo.getText().toString()));
                    oldEmployee.setSubThree(Integer.parseInt(subThree.getText().toString()));
                    oldEmployee.setSubFour(Integer.parseInt(subFour.getText().toString()));
                    oldEmployee.setSubFive(Integer.parseInt(subFive.toString()));
                    Toast t = Toast.makeText(AddUpdateStudent.this, "Employee "+ oldEmployee.getFirstname() + " has been updated successfully !", Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(AddUpdateStudent.this,MainActivity.class);
                    startActivity(i);

                }


            }
        });

    }
    private void initializeEmployee(long empId) {
        oldEmployee = employeeData.getEmployee(empId);
        firstNameEditText.setText(oldEmployee.getFirstname());
        lastNameEditText.setText(oldEmployee.getLastname());
        subOne.setText(oldEmployee.getSubOne());
        subTwo.setText(oldEmployee.getSubTwo());
        subThree.setText(oldEmployee.getSubThree());
        subFour.setText(oldEmployee.getSubFour());
        subFive.setText(oldEmployee.getSubFive());
    }

}
