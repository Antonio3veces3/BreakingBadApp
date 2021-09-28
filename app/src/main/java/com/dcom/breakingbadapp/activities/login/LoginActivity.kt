package com.dcom.breakingbadapp.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.dcom.breakingbadapp.activities.main.MainActivity
import com.dcom.breakingbadapp.R
import java.util.regex.Matcher
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.button_login)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val emailInt = email.text

        buttonLogin.setOnClickListener(){
            var emailValid = isEmailValid(emailInt.toString())
            Log.i("mz","Mail: $emailValid")
            if(email.text.isEmpty() || password.text.isEmpty()){
                Toast.makeText(this, "Please, type your email or password", Toast.LENGTH_LONG).show()
            }else {
                if (emailValid){
                    val intentButton = Intent(this, MainActivity::class.java)
                    startActivity(intentButton)
                    return@setOnClickListener
                }else{
                    Toast.makeText(this, "Please, put a valid email", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
    fun isEmailValid(email: String): Boolean {
        var patron: Pattern= Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")
        var mattcher: Matcher= patron.matcher((email))
        return mattcher.find()
    }
