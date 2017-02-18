package com.example.victor.mysqldbtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends Activity {
    //declareren
    EditText ET_FIRST_NAME, ET_LAST_NAME, ET_USER_NAME, ET_USER_EMAIL, ET_USER_EMAIL_CHECK, ET_USER_PASS, ET_USER_PASS_CHECK, ET_USER_BIRTH;
    String first_name, last_name, user_name, user_email, user_email_check, user_pass, user_pass_check, user_birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        EditText editText = (EditText)findViewById(R.id.new_first_name);
        editText.setSelection(0);

        ET_FIRST_NAME = (EditText)findViewById(R.id.new_first_name);
        ET_LAST_NAME = (EditText)findViewById(R.id.new_last_name);
        ET_USER_NAME = (EditText)findViewById(R.id.new_user_name);
        ET_USER_EMAIL = (EditText)findViewById(R.id.new_user_email);
        ET_USER_EMAIL_CHECK = (EditText)findViewById(R.id.new_user_email_check);
        ET_USER_PASS = (EditText)findViewById(R.id.new_user_pass);
        ET_USER_PASS_CHECK = (EditText)findViewById(R.id.new_user_pass_check);
        ET_USER_BIRTH = (EditText)findViewById(R.id.new_user_birth);

    }
    public void userLog(View view)
    {
        startActivity(new Intent(this, LoginActivity.class));
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
        user_birth = ET_USER_BIRTH.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, first_name, last_name, user_name, user_email, user_email_check, user_pass, user_pass_check, user_birth);
        finish();
    }
}
