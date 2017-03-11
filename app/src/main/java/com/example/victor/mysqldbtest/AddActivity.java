package com.example.victor.mysqldbtest;

import android.content.Intent;
import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText ET_NAME_ACTIVITY, ET_DESCRIPTION_ACTIVITY;
    String name_activity, description_activity, datum_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EditText editText = (EditText)findViewById(R.id.name_new_activity);
        editText.setSelection(0);

        ET_NAME_ACTIVITY = (EditText)findViewById(R.id.name_new_activity);
        ET_DESCRIPTION_ACTIVITY = (EditText)findViewById(R.id.description_new_activity);
    }
    public void userActivity(View view)
    {
        name_activity = ET_NAME_ACTIVITY.getText().toString();
        description_activity = ET_DESCRIPTION_ACTIVITY.getText().toString();

        Intent intent = getIntent();
        datum_activity = intent.getExtras().getString("Datum");

        String method = "activity";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, name_activity, description_activity, datum_activity);
        finish();
    }
}
