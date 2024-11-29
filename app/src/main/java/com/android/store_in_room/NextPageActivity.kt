package com.android.store_in_room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NextPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_next_page)

        val rv = findViewById<RecyclerView>(R.id.rv)


        CoroutineScope(Dispatchers.IO).launch {
            val user = AppDatabase.getDatabase(applicationContext).userDao().getAllUsers()
            withContext(Dispatchers.Main) {

                val adapter = UserAdapter(user)
                rv.adapter = adapter
                rv.layoutManager = LinearLayoutManager(this@NextPageActivity)

            }
        }
    }
}