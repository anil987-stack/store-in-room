package com.android.store_in_room

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.name)
        val genderEditText = findViewById<EditText>(R.id.gender)
        val addressEditText = findViewById<EditText>(R.id.address)
        val register = findViewById<Button>(R.id.button)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        register.setOnClickListener {
            val name = nameEditText.text.toString()
            val gender = genderEditText.text.toString()
            val address = addressEditText.text.toString()

            val user = UserModel(name = name, gender = gender, address = address)

            CoroutineScope(Dispatchers.IO).launch {
                AppDatabase.getDatabase(applicationContext).userDao().insertUser(user)
                Log.d("MainActivity", "User inserted: $user")
                startActivity(Intent(this@MainActivity, NextPageActivity::class.java))
            }

        }
    }

}