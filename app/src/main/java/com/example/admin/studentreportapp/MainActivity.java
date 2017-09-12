package com.example.admin.studentreportapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onButton_lacture_Click(View v)
    {

        if(v.getId() == R.id.btnLogin)
        {
            EditText userNam = (EditText)findViewById(R.id.edtUsername);
            String str = userNam.getText().toString();

            EditText passWord = (EditText) findViewById(R.id.edtPassword);
            String strPass = passWord.getText().toString();

            String password = helper.searchPass(str);
            if(strPass.equals(password))
            {
                Toast temp = Toast.makeText(MainActivity.this, "Username and Password don't match "+password+" "+strPass,Toast.LENGTH_SHORT);
                temp.show();

            }
            else
            {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                intent.putExtra("Username", str);
                startActivity(intent);
            }

        }
    }
    public void onCreate_Account(View v)
    {
        if(v.getId() == R.id.txtCreate_Acc)
        {
            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }
    }
}

