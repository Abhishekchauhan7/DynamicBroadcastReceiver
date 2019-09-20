package com.abhi.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Worker_Broadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val filter_intent = intent?.action

        if (filter_intent!=null) {
            when(filter_intent){
             Intent.ACTION_POWER_CONNECTED -> {
                 Toast.makeText(context,"Power Conected",Toast.LENGTH_LONG).show()
             }
             Intent.ACTION_POWER_DISCONNECTED -> {
                 Toast.makeText(context,"Power Disconnected",Toast.LENGTH_LONG).show()
             }
            }
        }



    }
}