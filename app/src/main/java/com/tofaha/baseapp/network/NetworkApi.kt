package com.tofaha.baseapp.network

import com.tofaha.baseapp.model.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*
import rx.Observable
import rx.internal.schedulers.NewThreadWorker

/**
 * Created by ayoub on 1/30/18.
 */

interface NetworkApi {

    @GET("/api/users/all")
    fun getAllUsers(): Observable<NetworkResponse>

    @GET("/api/users/user")
    fun getUser(@Query("id") id : String): Observable<NetworkResponse>

    @POST("/api/users/create")
    fun createUser(@Body user: User): Observable<NetworkResponse>

}