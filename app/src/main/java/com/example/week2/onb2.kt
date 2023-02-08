package com.example.week2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class onb2:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onb2)
        val button2 = findViewById<ImageButton>(R.id.button2)
        button2.setOnClickListener {
            startActivity(Intent(this@onb2, onb3::class.java))
        }
    }
}