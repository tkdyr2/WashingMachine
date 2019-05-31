package com.example.washingmachine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){

                Intent it = new Intent(getApplicationContext(),LoginActivity.class);

                it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //startActivity(new Intent(getApplicationContext(),MainPage.class));
                startActivity(it);
                finish();
            }
        },800);



    }



}
