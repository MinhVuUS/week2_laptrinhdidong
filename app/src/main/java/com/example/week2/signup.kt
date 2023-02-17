package com.example.week2
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week2.databinding.SignupBinding

class signup : AppCompatActivity() {

    private lateinit var binding: SignupBinding
    private lateinit var viewModel: SignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        binding = DataBindingUtil.setContentView(this, R.layout.signup)
        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

//
        binding.buttonSignUp.setOnClickListener {onSignUp()}
//        viewModel.isValid.observe(this){ isValid ->
//            if(isValid)
//            {
//                //update data store
//                DataStore.userDataStore.add(mutableMapOf(
//                    "fullName" to binding.fullNameInputText.text.toString(),
//                    "email" to binding.emailInputText.text.toString(),
//                    "password" to binding.passwordInputText.text.toString(),
//                ))
//
//                Log.i("DataStore", DataStore.userDataStore.toString())
//            }
//
//            else
//                Log.i("SignUp", "False")
//        }
//    }
        binding.textViewSignin.setOnClickListener {
            startActivity(Intent(this, Signin::class.java))
            finish()
        }
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
            if (isSuccess) {
                // Success
                DataStore.userDataStore.add(
                    mutableMapOf(
                        "fullName" to binding.fullNameInputText.text.toString(),
                        "email" to binding.emailInputText.text.toString(),
                        "password" to binding.passwordInputText.text.toString()
                    )
                )
                Toast.makeText(this, "SignUp Success", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun onSignUp() {
        viewModel.onSignUp(binding.fullNameInputText.text.toString(),
            binding.emailInputText.text.toString(),
            binding.passwordInputText.text.toString())
    }
    }
