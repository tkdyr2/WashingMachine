package com.example.washingmachine

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MyInformation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_information)


        val confirmation = findViewById<View>(R.id.sent3) as Button
        confirmation.setOnClickListener {
            val intent = Intent(
                applicationContext,
                MenuActivity::class.java
            )
            startActivity(intent)
        }
    }
}
