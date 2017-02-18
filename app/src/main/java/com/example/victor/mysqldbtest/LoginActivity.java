package com.example.victor.mysqldbtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
    EditText ET_NAME, ET_PASS;
    String login_name, login_pass;
    Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ET_NAME = (EditText)findViewById(R.id.login_Name);
        ET_PASS = (EditText)findViewById(R.id.login_Paswoord);

        loginbutton = (Button)findViewById(R.id.button_Login);

        final TextView link_Register = (TextView) findViewById(R.id.link_Register);
        link_Register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerPageIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerPageIntent);
            }
        });
    }

    public void userReg(View view)
    {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void userLogin(View view)
    {
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, login_name, login_pass);
    }
}
