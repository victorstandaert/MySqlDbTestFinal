package com.example.victor.mysqldbtest;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.N)
public class UserAreaActivity extends AppCompatActivity {

    Button AddActivity;
    CalendarView calendarView;
    int Jaar;
    int Maand;
    int Dag;
    String Datum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        AddActivity = (Button)findViewById(R.id.btn_add);
        calendarView = (CalendarView)findViewById(R.id.calendarView1);
    }


    public void NewActivity(View view)
    {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth)
            {
                Dag = dayOfMonth;
                Maand = month;
                Jaar = year;

                Datum = Dag + "/" + Maand + "/" + Jaar;
            }
        });

        Intent i = new Intent(this, AddActivity.class);
        i.putExtra("Datum", Datum);
        startActivity(i);
    }
}
