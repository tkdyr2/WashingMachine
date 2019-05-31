package com.example.washingmachine

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class LookNoticeWhole : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.look_notice_whole)
        val sent2 = findViewById<View>(R.id.sent3) as Button
        sent2.setOnClickListener {
            val intent = Intent(
                applicationContext,
                MenuActivity::class.java
            )
            startActivity(intent)
        }

        val Cancellation = findViewById<View>(R.id.cancellation2) as Button
        Cancellation.setOnClickListener {
            val intent = Intent(
                applicationContext,
                MakeNotice::class.java
            )
            startActivity(intent)
        }

    }


}
