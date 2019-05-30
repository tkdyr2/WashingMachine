package com.example.washingmachine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyWashingMachineActivity  extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mywashingmachine);


        Button okbtn = (Button) findViewById(R.id.okbtn);


        okbtn.setOnClickListener(new View.OnClickListener() {            //마이세탁기화면 확인버튼 누를시 메뉴화면으로 돌아감
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        MenuActivity.class);
                startActivity(intent);
            }
        });





    }

}