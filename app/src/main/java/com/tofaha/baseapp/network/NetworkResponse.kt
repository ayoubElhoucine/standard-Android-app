package com.tofaha.baseapp.network

import android.graphics.Bitmap
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.tofaha.baseapp.model.User

/**
 * Created by ayoub on 1/30/18.
 */

class NetworkResponse {

    @SerializedName("code")
    @Expose
    var code : String? = null

    @SerializedName("message")
    @Expose
    var message : String? = null

    @SerializedName("token")
    @Expose
    var token : String? = null

    @SerializedName("user")
    @Expose
    var user : User? = null

}
