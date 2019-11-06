package com.tofaha.baseapp.session

import android.content.Context
import android.content.SharedPreferences
import com.tofaha.baseapp.app.Constants

/**
 * Created by ayoub on 3/24/18.
 */
class Session (val context: Context) {

    private var preferences : SharedPreferences? = null

    init {
        this.preferences = context.getSharedPreferences(context.packageName , 0)
    }

    var password: String?
        get() = this.preferences!!.getString(Constants.PASSWORD, "")
        set(password) = this.preferences!!.edit().putString(Constants.PASSWORD, password).apply()

    var userName: String?
        get() = this.preferences!!.getString(Constants.USER_NAME, "")
        set(userName) = this.preferences!!.edit().putString(Constants.USER_NAME, userName).apply()

    var token: String?
        get() = this.preferences!!.getString(Constants.TOKEN, null)
        set(userId) = this.preferences!!.edit().putString(Constants.TOKEN, userId).apply()

    var ipAddress: String?
        get() = this.preferences!!.getString(Constants.IP_ADDRESS, null)
        set(ipAddress) = this.preferences!!.edit().putString(Constants.IP_ADDRESS, ipAddress).apply()

    var language: String?
        get() = this.preferences!!.getString(Constants.LANGUAGE, "fr")
        set(lan) = this.preferences!!.edit().putString(Constants.LANGUAGE, lan).apply()

}