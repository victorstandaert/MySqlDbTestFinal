package com.example.victor.mysqldbtest;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import layout.BlankFragment;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Home extends AppCompatActivity {

    Button AddActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AddActivity = (Button)findViewById(R.id.btn_add);
    }

    public void NewActivity(View view)
    {
        startActivity(new Intent(this, AddActivity.class));
    }
}
