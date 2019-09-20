package com.abhi.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {

    private var coworker = Worker_Broadcast()
    private val CUSTOMBROADCAST = BuildConfig.APPLICATION_ID + ".CUSTOM_BROADCAST"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        this.registerReceiver(coworker,filter)
        LocalBroadcastManager.getInstance(this).registerReceiver(coworker,IntentFilter(CUSTOMBROADCAST))
        sendBroadcast()
    }


    private fun sendBroadcast(){
        val customBroadcastIntent = Intent(CUSTOMBROADCAST)
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent)
    }


    override fun onDestroy() {
        this.unregisterReceiver(coworker)
        LocalBroadcastManager.getInstance(this).unregisterReceiver(coworker)
        super.onDestroy()

    }
}
