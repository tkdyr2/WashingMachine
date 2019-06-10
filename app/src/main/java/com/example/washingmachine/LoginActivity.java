package com.example.washingmachine;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity  extends Activity {

    String json;
    Button loginbtn;
    EditText idtext, pwtext;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginbtn = (Button) findViewById(R.id.loginbutton);
        Button registerBtn = (Button) findViewById(R.id.registerButton);

        idtext = findViewById(R.id.idtext);
        pwtext = findViewById(R.id.passwordtext);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginDB task = new LoginDB();
                task.execute("http://192.168.55.140/PHP_connection.php");

            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        Registration.class);
                startActivity(intent);
            }
        });

    }


    private class LoginDB extends AsyncTask<String, Void, String> {
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if(result==null){
                Toast.makeText(getApplicationContext(),"데이터가 없습니다.(ERROR)",Toast.LENGTH_SHORT).show();
            }else {
                json = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {
            String serverURL = params[0];

            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); //오픈커넥터

                httpURLConnection.setReadTimeout(5000); //읽기타임아웃
                httpURLConnection.setConnectTimeout(5000); //연결타임아웃
                httpURLConnection.connect();

                int responseStatusCode = httpURLConnection.getResponseCode();

                InputStream inputStream; //1바이트씩 읽어오는
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8"); // utf-8 문자집합의 인풋스트림리더
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //인풋스트림리더로부터 라인단위로 데이터를 읽음

                StringBuilder sb = new StringBuilder(); //변할 수 있음
                String line; //값이 변하지 않음 // 값이 바뀔때마다 메모리를 다시 할당함

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }
                bufferedReader.close();
                return sb.toString().trim();
            }
            catch (Exception e) {
                Log.d("TESTLOG","error1");
                errorString = e.toString();
                return null;
            }
        }
    }

    private void showResult(){
        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("result");

            boolean login = false;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject item = jsonArray.getJSONObject(i);
                String id = item.getString("id");
                String pw = item.getString("pw");

                if(id.equals(idtext.getText().toString()) && pw.equals(pwtext.getText().toString())){

                    Intent intent = new Intent(getApplicationContext(),
                            MenuActivity.class);
                    startActivity(intent);

                    groval.id = id;
                    groval.pw = pw;

                    Toast.makeText(getApplicationContext(), "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    login = true;
                }

            }

            if(login == false){
                Toast.makeText(getApplicationContext(), "아이디가 없습니다.", Toast.LENGTH_SHORT).show();
            }


        } catch (JSONException e) {
        }
    }


}
