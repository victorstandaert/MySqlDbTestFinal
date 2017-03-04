package com.example.victor.mysqldbtest;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

@RequiresApi(api = Build.VERSION_CODES.N)
public class UserAreaActivity extends AppCompatActivity {

    Button AddActivity;
    Calendar Calendar;
    int Jaar;
    int Maand;
    int Dag;
    String Datum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        AddActivity = (Button)findViewById(R.id.btn_add);

    }

    public void NewActivity(View view)
    {
        Jaar = Calendar.get(Calendar.YEAR);
        Maand = Calendar.get(Calendar.MONTH);
        Dag = Calendar.get(Calendar.DAY_OF_MONTH);
        Datum = Dag + "/" + Maand + "/" + Jaar;

        startActivity(new Intent(this, AddActivity.class));
    }
}
