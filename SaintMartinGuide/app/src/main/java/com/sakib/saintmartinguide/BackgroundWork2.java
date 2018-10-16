package com.sakib.saintmartinguide;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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


public class BackgroundWork2 extends AsyncTask<String, Void, String> {

    Context ctx;
    AlertDialog alertDialog;
    String route="";
    String hotelname="";

    public BackgroundWork2(Context ctx){
        this.ctx=ctx;
    }



    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information");

    }


    @Override
    protected String doInBackground(String... params) {
        String reg_url="http://chowdhurysakib.info/rahman/register.php";
        String login_url="http://chowdhurysakib.info/rahman/login.php";


        String method=params[0];
        if(method.equals("register")){
            String name=params[1];
            String pass=params[2];
            String nId=params[3];
            String contact=params[4];
            String mail=params[5];
            String address=params[6];

            try {
                URL url =new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data  = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                data += "&" + URLEncoder.encode("contact", "UTF-8") + "=" + URLEncoder.encode(contact, "UTF-8");
                data += "&" + URLEncoder.encode("mail", "UTF-8") + "=" + URLEncoder.encode(mail, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream is=httpURLConnection.getInputStream();
                is.close();
                return "registration success...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login")){
            String login_name=params[1];
            String login_pass=params[2];

            hotelname=params[3];

            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data  = URLEncoder.encode("login_name", "UTF-8") + "=" + URLEncoder.encode(login_name, "UTF-8");
                data += "&" + URLEncoder.encode("login_pass", "UTF-8") + "=" + URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    response+=line;
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


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    //MainActivity mainActivity=new MainActivity();
    @Override
    protected void onPostExecute(String result) {
        if (result=="registration success...") {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }else if (result.equals("success")) {
            // mainActivity.lgnUsername.setText("");
            // mainActivity.lgnPass.setText("");
            Intent i=new Intent(ctx,UserView.class);

            i.putExtra("planename",hotelname);
            ctx.startActivity(i);
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();


            // startActivity(i);

        }

        else {
            alertDialog.setMessage(result);
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            alertDialog.show();
        }
    }
}
