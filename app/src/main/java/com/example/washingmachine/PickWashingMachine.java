package com.example.washingmachine;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PickWashingMachine  extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickwashingmachine);

        ImageButton rm1 = (ImageButton) findViewById(R.id.room1machine1);
        ImageButton rm2 = (ImageButton) findViewById(R.id.room1machine2);
        ImageButton rm3 = (ImageButton) findViewById(R.id.room1machine3);
        ImageButton rm4 = (ImageButton) findViewById(R.id.room1machine4);
        ImageButton rm5 = (ImageButton) findViewById(R.id.room1machine5);
        ImageButton rm6 = (ImageButton) findViewById(R.id.room1machine6);



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










    }

}



