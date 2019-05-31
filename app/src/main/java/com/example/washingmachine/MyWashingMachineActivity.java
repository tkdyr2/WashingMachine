package com.example.washingmachine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MyWashingMachineActivity  extends Activity {

    ProgressBar pb;
    Handler handler = new Handler();
    Boolean flag = false;
    int count=0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mywashingmachine);

        pb = findViewById(R.id.progress2);
        pb.setMax(100);
        pb.setProgress(0);



        Button okbtn = (Button) findViewById(R.id.okbtn);

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (!flag){

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.setProgress(++count);
                        }
                    });

                }
            }
        }).start();


        okbtn.setOnClickListener(new View.OnClickListener() {            //마이세탁기화면 확인버튼 누를시 메뉴화면으로 돌아감
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        MenuActivity.class);
                startActivity(intent);
            }
        });





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = true;
    }
}