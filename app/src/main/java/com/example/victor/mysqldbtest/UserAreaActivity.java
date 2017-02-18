package com.example.victor.mysqldbtest;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

@RequiresApi(api = Build.VERSION_CODES.N)
public class UserAreaActivity extends AppCompatActivity {

    Button AddActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        AddActivity = (Button)findViewById(R.id.btn_add);
    }

    public void NewActivity(View view)
    {
        startActivity(new Intent(this, AddActivity.class));
    }
}
