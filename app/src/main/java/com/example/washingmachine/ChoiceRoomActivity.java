package com.example.washingmachine;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class ChoiceRoomActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choiceroom);

        ImageButton rm1 = (ImageButton)findViewById(R.id.room1);
        ImageButton rm2 = (ImageButton)findViewById(R.id.room2);
        ImageButton rm3 = (ImageButton)findViewById(R.id.room3);
        ImageButton rm4 = (ImageButton)findViewById(R.id.room4);
        ImageButton rm5 = (ImageButton)findViewById(R.id.room5);


        rm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        PickWashingMachine.class);
                startActivity(intent);
            }
        });


        rm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        PickWashingMachine.class);
                startActivity(intent);
            }
        });



        rm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        PickWashingMachine.class);
                startActivity(intent);
            }
        });




        rm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        PickWashingMachine.class);
                startActivity(intent);
            }
        });




        rm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        PickWashingMachine.class);
                startActivity(intent);
            }
        });





    }

}
