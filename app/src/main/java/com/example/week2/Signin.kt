package com.example.week2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_screen)
        val username = findViewById<EditText>(R.id.edtusername)
        val password = findViewById<EditText>(R.id.edtpassword)
        password.transformationMethod = android.text.method.PasswordTransformationMethod.getInstance()
        val loginButton = findViewById<ImageButton>(R.id.login)
        loginButton.setOnClickListener {
            if (username.text.toString() == "username@gmail.com" && password.text.toString() == "123456") {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@Signin, profile::class.java))
            } else {
                Toast.makeText(this, "Login failed! Try again", Toast.LENGTH_SHORT).show()

            }
        }
}}