package com.tofaha.baseapp.util

import android.content.Context
import android.content.Intent
import android.app.AlarmManager
import android.app.PendingIntent
import com.tofaha.baseapp.ui.main.MainActivity

object AppUtil {

    /*fun restartApp(context : Context){
        val i = context.packageManager
                .getLaunchIntentForPackage(context.getPackageName())
        i!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(i)
    }*/

    fun restartApp(context : Context) {
        val intent = Intent(context.getApplicationContext(), MainActivity::class.java)
        val mPendingIntentId = 0
        val mPendingIntent = PendingIntent.getActivity(context.getApplicationContext(), mPendingIntentId, intent, PendingIntent.FLAG_CANCEL_CURRENT)
        val mgr = context.getApplicationContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent)
        System.exit(0)
    }

}