package com.tofaha.baseapp.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tofaha.baseapp.model.User
import org.json.JSONObject

object JsonUtil {

    fun convertJsonToObject(qr : String){
        var gson = Gson()
        var jsonObjcet = JSONObject(qr)
        val turnsType = object : TypeToken<User>() {}.type
        //MyData.qr_model = gson.fromJson<User>(qr , turnsType) as User
    }

}