package com.example.tbctask32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.method.TextKeyListener.clear
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.contracts.ReturnsNotNull

class MainActivity : AppCompatActivity() {
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       saveButton=findViewById(R.id.saveButton)
        clearButton=findViewById(R.id.clearButton)


        saveButton.setOnClickListener {checking() }
        clearButton.setOnLongClickListener { delete() }

    }


    private fun checking():Boolean {
        val firstname = edit_firstName.text.toString()
        val lastname = edit_lastName.text.toString()
        val age = edit_age.text.toString()
        val username = edit_Username.text.toString()
        var email = findViewById<EditText>(R.id.edit_email).text.toString().trim()
        val minimumSize=10
        if (!firstname.isNotEmpty() || !lastname.isNotEmpty() || !username.isNotEmpty() ||!age.isNotEmpty()||!email.isNotEmpty())

        {
            Toast.makeText(this, "Please fill in every gap", Toast.LENGTH_SHORT).show()

        }

        if(username.length>0 && username.length <minimumSize){
          Toast.makeText(this,"Username must include more than 10 char.",Toast.LENGTH_SHORT).show()

          }

        if (!email.matches(emailPattern.toRegex())) {
                Toast.makeText(
                    this, "Invalid email address",
                    Toast.LENGTH_LONG
                ).show()
        }
        return true
    }
    private fun delete(): Boolean {

        findViewById<EditText>(R.id.edit_firstName).text.clear()
        findViewById<EditText>(R.id.edit_lastName).text.clear()
        findViewById<EditText>(R.id.edit_age).text.clear()
        findViewById<EditText>(R.id.edit_Username).text.clear()
        findViewById<EditText>(R.id.edit_email).text.clear()

        return true


    }

    private fun emailValidation(email:String):Boolean{
         android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        return true
    }
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"


}





