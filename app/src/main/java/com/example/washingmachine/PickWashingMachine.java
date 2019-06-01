package com.example.washingmachine;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PickWashingMachine  extends Activity {

    TextView tv1;

    String json;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickwashingmachine);

        tv1 = findViewById(R.id.tv1);

        LinearLayout rm1 = (LinearLayout) findViewById(R.id.room1machine1);
        LinearLayout rm2 = (LinearLayout) findViewById(R.id.room1machine2);
        LinearLayout rm3 = (LinearLayout) findViewById(R.id.room1machine3);
        LinearLayout rm4 = (LinearLayout) findViewById(R.id.room1machine4);
        LinearLayout rm5 = (LinearLayout) findViewById(R.id.room1machine5);
        LinearLayout rm6 = (LinearLayout) findViewById(R.id.room1machine6);



        rm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 =new AlertDialog.Builder(PickWashingMachine.this);
                builder1.setTitle("1번 세탁기");
                //builder.setNeutralButton("닫기",null);    //닫기버튼
                builder1.setMessage("이 세탁기를 예약하시겠습니까?");     //메세지를 입력
                builder1.setPositiveButton("네",null);    //긍정버튼
                builder1.setNegativeButton("아니요",null);  //부정버튼
                builder1.create().show();



            }
        });


        rm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder2 =new AlertDialog.Builder(PickWashingMachine.this);
                builder2.setTitle("2번 세탁기");
                builder2.setMessage("이 세탁기를 예약하시겠습니까?");     //메세지를 입력
                //builder.setNeutralButton("닫기",null);    //닫기버튼
                builder2.setPositiveButton("네",null);    //긍정버튼
                builder2.setNegativeButton("아니요",null);  //부정버튼
                builder2.create().show();



            }
        });


        rm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder3 =new AlertDialog.Builder(PickWashingMachine.this);
                builder3.setTitle("3번 세탁기");
                builder3.setMessage("이 세탁기를 예약하시겠습니까?");     //메세지를 입력
                //builder.setNeutralButton("닫기",null);    //닫기버튼
                builder3.setPositiveButton("네",null);    //긍정버튼
                builder3.setNegativeButton("아니요",null);  //부정버튼
                builder3.create().show();



            }
        });


        rm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder4 =new AlertDialog.Builder(PickWashingMachine.this);
                builder4.setTitle("4번 세탁기");
                builder4.setMessage("이 세탁기를 예약하시겠습니까?");     //메세지를 입력
                // builder.setNeutralButton("닫기",null);    //닫기버튼
                builder4.setPositiveButton("네",null);    //긍정버튼
                builder4 .setNegativeButton("아니요",null);  //부정버튼
                builder4.create().show();



            }
        });



        rm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder5 =new AlertDialog.Builder(PickWashingMachine.this);
                builder5.setTitle("5번 세탁기");
                builder5.setMessage("이 세탁기를 예약하시겠습니까?");     //메세지를 입력
                // builder.setNeutralButton("닫기",null);    //닫기버튼
                builder5.setPositiveButton("네",null);    //긍정버튼
                builder5 .setNegativeButton("아니요",null);  //부정버튼
                builder5.create().show();



            }
        });



        rm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder6 =new AlertDialog.Builder(PickWashingMachine.this);
                builder6.setTitle("6번 세탁기");
                builder6.setMessage("이 세탁기를 예약하시겠습니까?");     //메세지를 입력
                // builder.setNeutralButton("닫기",null);    //닫기버튼
                builder6.setPositiveButton("네",null);    //긍정버튼
                builder6 .setNegativeButton("아니요",null);  //부정버튼
                builder6.create().show();



            }
        });


        LoginDB task = new LoginDB();
        task.execute("http://wshwan15.cafe24.com/WM_test.php");



    }
    //end of oncreate

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
            JSONArray jsonArray = jsonObject.getJSONArray("webnautes");

            boolean login = false;
            for (int i = 0; i < jsonArray.length(); i++) { //가져오는 거임

                JSONObject item = jsonArray.getJSONObject(i);
                String id = item.getString("id");
                String pw = item.getString("pw");


                tv1.setText("세탁기번호1:"+id + "\n다음 예약자 수" + pw );

            }


        } catch (JSONException e) {
        }
    }

}



