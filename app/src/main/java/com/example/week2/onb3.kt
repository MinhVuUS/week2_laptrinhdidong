package com.example.week2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class onb3:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onb3)
        val button3 = findViewById<ImageButton>(R.id.Button3)
        button3.setOnClickListener {
            startActivity(Intent(this@onb3, Welcome_Screen::class.java))
        }
}}