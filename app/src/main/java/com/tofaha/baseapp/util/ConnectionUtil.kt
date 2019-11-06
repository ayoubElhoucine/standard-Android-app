package com.tofaha.baseapp.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import kotlin.jvm.internal.Intrinsics

object ConnectionUtil {

    @SuppressLint("NewApi")
    fun isConnectingToInternet(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= 21) {
            val networks = connectivityManager!!.allNetworks
            for (mNetwork in networks) {
                val networkInfo = connectivityManager.getNetworkInfo(mNetwork)
                Intrinsics.checkExpressionValueIsNotNull(networkInfo, "connectivityManager.getNetworkInfo(mNetwork)")
                if (Intrinsics.areEqual(networkInfo.state, NetworkInfo.State.CONNECTED)) {
                    return true
                }
            }
            return false
        } else if (connectivityManager == null) {
            return false
        } else {
            val info = connectivityManager.allNetworkInfo ?: return false
            for (anInfo in info) {
                if (Intrinsics.areEqual(anInfo.state, NetworkInfo.State.CONNECTED)) {
                    return true
                }
            }
            return false
        }
    }

}