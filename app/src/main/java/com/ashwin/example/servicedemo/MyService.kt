package com.ashwin.example.servicedemo

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

/**
 * Created by Ashwin on 30-08-2017.
 */

class MyService : Service() {

    var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer?.stop()

        Log.d(getString(R.string.app_tag), "onStartCommand() : Thread : " + Thread.currentThread().id)
        mediaPlayer = MediaPlayer.create(this, R.raw.despacito)
        mediaPlayer?.start()

        //stopSelf()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        Log.d(getString(R.string.app_tag), "onDestroy() : Thread : " + Thread.currentThread().id)
        mediaPlayer?.stop()
        super.onDestroy()
    }
}