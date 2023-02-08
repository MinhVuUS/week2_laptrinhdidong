package com.example.week2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        val view = layoutInflater.inflate(R.layout.dialogalert, null)
        val nameInput = view.findViewById<EditText>(R.id.etname)
        val emailInput = view.findViewById<EditText>(R.id.etemail)
        val phoneInput = view.findViewById<EditText>(R.id.etphone)
        val buttonalert = findViewById<EditText>(R.id.edtname)

        buttonalert.setOnClickListener() {
            AlertDialog.Builder(this)
                .setView(view)
                .setPositiveButton("OK") { dialog, which ->
                    val name = nameInput.text.toString()
                    val email = emailInput.text.toString()
                    val phone = phoneInput.text.toString()
                    // Do something with the input text
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }
                .show()


        }
        }
}