package com.example.victor.mysqldbtest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Victor on 9-11-2016.
 */

public class BackgroundTask extends AsyncTask<String,Void,String>{
    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx = ctx;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login information...");

    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://www.vhsj.be/websites/6ib/projectjv/webapp/register.php";
        String login_url = "http://www.vhsj.be/websites/6ib/projectjv/webapp/login.php";
        String activity_url = "http://www.vhsj.be/websites/6ib/projectjv/webapp/new_activity.php";
        String method = params[0];
        if(method.equals("register"))
        {
            String first_name = params[1];
            String last_name = params [2];
            String user_name = params[3];
            String user_email = params[4];
            String user_email_check = params[5];
            String user_pass = params[6];
            String user_pass_check = params[7];
            String user_birth = params[8];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("first_name", "UTF-8")+ "=" + URLEncoder.encode(first_name,"UTF-8") + "&" +
                        URLEncoder.encode("last_name", "UTF-8")+ "=" + URLEncoder.encode(last_name,"UTF-8") + "&" +
                        URLEncoder.encode("user_name", "UTF-8")+ "=" + URLEncoder.encode(user_name,"UTF-8") + "&" +
                        URLEncoder.encode("user_email", "UTF-8")+ "=" + URLEncoder.encode(user_email,"UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8")+ "=" + URLEncoder.encode(user_pass,"UTF-8") + "&" +
                        URLEncoder.encode("user_birth", "UTF-8")+ "=" + URLEncoder.encode(user_birth,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(method.equals("login"))
        {
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                    URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while((line = bufferedReader.readLine())!= null)
                {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(method.equals("activity"))
        {
            String name_activity  = params[1];
            String description_activity = params [2];
            String datum_activity = params [3];

            try {
                URL url = new URL(activity_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("name_activity", "UTF-8")+ "=" + URLEncoder.encode(name_activity,"UTF-8") + "&" +
                        URLEncoder.encode("description_activity", "UTF-8")+ "=" + URLEncoder.encode(description_activity,"UTF-8") + "&" +
                        URLEncoder.encode("datum_activity", "UTF-8")+ "=" + URLEncoder.encode(datum_activity,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Activity added...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Success..."))
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.equals("Activity added..."))
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.equals("Login success, welcome"))
        {
            Intent i = new Intent(ctx, UserAreaActivity.class);
            ctx.startActivity(i);
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        else if(result.equals("Login failed"))
        {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}
