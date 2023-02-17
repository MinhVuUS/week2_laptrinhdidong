package com.example.week2
import android.os.Bundle

import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week2.databinding.ProfileBinding

class profile : AppCompatActivity() {
    private lateinit var binding: ProfileBinding
    private lateinit var viewModel: ProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.profile)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

//        binding.edtname.text = DataStore.currentUserData["fullName"]
//        binding.edtfullname.text = DataStore.currentUserData["fullName"]
//        binding.edtmail.text = DataStore.currentUserData["email"]
//        binding.edtphone.text = DataStore.currentUserData["phoneNumber"]


        binding.edtfullname.setOnClickListener {
            alertDialog("fullName", viewModel).show(
                supportFragmentManager, "dialogalert"

            )
        }

        binding.edtmail.setOnClickListener {
            alertDialog("email", viewModel).show(
                supportFragmentManager, "dialogalert"

            )
        }

        binding.edtphone.setOnClickListener {
            alertDialog("phoneNumber", viewModel).show(
                supportFragmentManager, "dialogalert"

            )
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
        viewModel.isSuccessEvent.observe(this) { successUserKey ->
            onDialogSubmitFinish(successUserKey)
        }
    }

    private fun onDialogSubmitFinish(fieldName: String) {
//        when (fieldName) {
//            "fullName" -> {
//                binding.edtname.text = DataStore.currentUserData[fieldName]
//                binding.edtfullname.text = DataStore.currentUserData[fieldName]
//            }
//            "email" -> binding.edtmail.text = DataStore.currentUserData[fieldName]
//            "phoneNumber" -> binding.edtphone.text = DataStore.currentUserData[fieldName]
//        }

    }
}