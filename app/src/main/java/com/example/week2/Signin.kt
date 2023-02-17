package com.example.week2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week2.databinding.SigninScreenBinding

class Signin : AppCompatActivity() {
    private lateinit var viewModel: SigninViewModel
    private lateinit var binding: SigninScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_screen)
        binding = DataBindingUtil.setContentView(this, R.layout.signin_screen)
        viewModel = ViewModelProvider(this).get(SigninViewModel::class.java)
        binding.lifecycleOwner = this
        binding.back.setOnClickListener{
            onBackPressed()
        }
        binding.login.setOnClickListener { loginOnClick() }
        binding.signin2.setOnClickListener { onSignUpNavigate() }

        listenerSuccessEvent()
        listenerErrorEvent()

    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) { errMsg ->
            Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { isSuccess ->
            if(isSuccess)
            {
                // Success
                Toast.makeText(this, "SignIn Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, profile::class.java))
            }
        }
    }

    private fun onSignUpNavigate() {
        startActivity(Intent(this, signup::class.java))
        finish()
    }

    private fun loginOnClick() {
        viewModel.onLogin(binding.edtusername.text.toString(), binding.edtpassword.text.toString())
    }



}