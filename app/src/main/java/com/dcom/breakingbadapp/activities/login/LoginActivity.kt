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
            if(email.text.isEmpty() || password.text.isEmpty()){
                Toast.makeText(this, "Please, type your email or password", Toast.LENGTH_LONG).show()
            }else if(emailValid==true){
                    val intentButton = Intent(this, MainActivity::class.java)
                    startActivity(intentButton)
                    return@setOnClickListener
            }
            Toast.makeText(this, "ESTA MAL", Toast.LENGTH_LONG).show()
        }
    }
}
    fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }
