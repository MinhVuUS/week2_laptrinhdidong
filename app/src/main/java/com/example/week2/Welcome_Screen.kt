package com.example.week2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Welcome_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome)
        val start2 = findViewById<ImageButton>(R.id.start2)
        val loginbtn = findViewById<Button>(R.id.textViewSignin)
        start2.setOnClickListener {
            startActivity(Intent(this@Welcome_Screen, signup::class.java))
        }
        loginbtn.setOnClickListener{
            startActivity(Intent(this@Welcome_Screen, Signin::class.java))
        }
    }
}