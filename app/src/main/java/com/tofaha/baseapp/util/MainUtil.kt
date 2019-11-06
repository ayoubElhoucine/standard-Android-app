package com.tofaha.baseapp.util

import android.content.Context
import android.content.Intent
import com.tofaha.baseapp.ui.main.MainActivity

object MainUtil {

    fun startMainActivity(context: Context){
        var intent = Intent(context , MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

}