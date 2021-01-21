package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FlashImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_image)

        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            startActivity(Intent(
                    this@FlashImageActivity,
                    MainActivity::class.java
            ))
            finish()
        }
    }
}