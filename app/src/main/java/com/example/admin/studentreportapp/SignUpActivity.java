package com.example.admin.studentreportapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText name, email, password, confim_password, username;

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }
    public void onClickDone(View v)
    {
        Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void onSignUp(View v)
    {
        name = (EditText)findViewById(R.id.edName);
        email = (EditText) findViewById(R.id.edtEmail);
        password = (EditText)findViewById(R.id.TFpassword);
        confim_password = (EditText)findViewById(R.id.TFConfirmPass);
        username = (EditText)findViewById(R.id.TFusername);

        String theName = name.getText().toString();
        String theEmail = email.getText().toString();
        String thePassword = password.getText().toString();
        String theUsername = username.getText().toString();
        String theConfirm = confim_password.getText().toString();

        if(!thePassword.equals(theConfirm))
        {
            //pop message

            Toast pass = Toast.makeText(SignUpActivity.this, "Password don't match ",Toast.LENGTH_SHORT);
            pass.show();
        }
        else
        {
            //insert the details in database
            Contact c = new Contact();
            c.setName(theName);
            c.setEmail(theEmail);
            c.setUsername(theUsername);
            c.setPass(thePassword);

            helper.insertContact(c);
        }


    }
}
