package com.ashwin.example.servicedemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(getString(R.string.app_tag), "onCreate() : Thread : " + Thread.currentThread().id)
        initViews()
    }

    private fun initViews() {
        startServiceButton.setOnClickListener {
            Thread(Runnable {
                val intent = Intent(this@MainActivity, MyService::class.java)
                startService(intent)
            }).start()
        }

        stopServiceButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MyService::class.java)
            stopService(intent)
        }
    }
}
