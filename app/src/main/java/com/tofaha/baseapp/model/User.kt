package com.tofaha.baseapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    @Expose
    var id : String? = null

    @SerializedName("name")
    @Expose
    var name : String? = null

    @SerializedName("email")
    @Expose
    var email : String? = null

    constructor()

    constructor(id: String?, name: String? , email : String?) {
        this.id = id
        this.name= name
        this.email = email
    }
}