package com.example.week2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val button1 = findViewById<ImageButton>(R.id.button1)
        button1.setOnClickListener{
            startActivity(Intent(this@MainActivity, onb2::class.java))

        }
        }
}