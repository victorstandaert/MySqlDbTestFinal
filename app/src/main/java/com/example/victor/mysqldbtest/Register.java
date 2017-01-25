package com.example.victor.mysqldbtest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

public class Register extends Activity {
    //declareren
    EditText ET_FIRST_NAME, ET_LAST_NAME, ET_USER_NAME, ET_USER_EMAIL, ET_USER_EMAIL_CHECK, ET_USER_PASS, ET_USER_PASS_CHECK, ET_USER_BIRTH;
    String first_name, last_name, user_name, user_email, user_email_check, user_pass, user_pass_check, user_birth;
    NumberPicker noPicker1 = null, noPicker2 = null, noPicker3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        ET_FIRST_NAME = (EditText)findViewById(R.id.new_first_name);
        ET_LAST_NAME = (EditText)findViewById(R.id.new_last_name);
        ET_USER_NAME = (EditText)findViewById(R.id.new_user_name);
        ET_USER_EMAIL = (EditText)findViewById(R.id.new_user_email);
        ET_USER_EMAIL_CHECK = (EditText)findViewById(R.id.new_user_email_check);
        ET_USER_PASS = (EditText)findViewById(R.id.new_user_pass);
        ET_USER_PASS_CHECK = (EditText)findViewById(R.id.new_user_pass_check);

        //Number Picker 1
        noPicker1 = (NumberPicker)findViewById(R.id.numberPicker1);
        noPicker1.setMaxValue(2017);
        noPicker1.setMinValue(1900);
        noPicker1.setWrapSelectorWheel(true);
        noPicker1.setValue(2017);
        //Number Picker 2
        noPicker2 = (NumberPicker)findViewById(R.id.numberPicker2);
        noPicker2.setMaxValue(12);
        noPicker2.setMinValue(01);
        noPicker2.setWrapSelectorWheel(true);
        //Number Picker 3
        noPicker3 = (NumberPicker)findViewById(R.id.numberPicker3);
        noPicker3.setMaxValue(31);
        noPicker3.setMinValue(1);
        noPicker3.setWrapSelectorWheel(true);
    }
    public void userLog(View view)
    {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void userReg(View view)
    {
        first_name = ET_FIRST_NAME.getText().toString();
        last_name = ET_LAST_NAME.getText().toString();
        user_name = ET_USER_NAME.getText().toString();
        user_email = ET_USER_EMAIL.getText().toString();
        user_email_check = ET_USER_EMAIL_CHECK.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();
        user_pass_check = ET_USER_PASS_CHECK.getText().toString();
        user_birth = noPicker1.toString(); user_birth += noPicker2.toString(); user_birth += noPicker3.toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, first_name, last_name, user_name, user_email, user_email_check, user_pass, user_pass_check, user_birth);
        finish();
    }
}
