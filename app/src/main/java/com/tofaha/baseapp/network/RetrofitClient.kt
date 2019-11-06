package com.tofaha.baseapp.network

import com.tofaha.baseapp.app.Constants
import com.tofaha.baseapp.network.interceptors.LoggingInterceptor
import com.tofaha.baseapp.session.Session
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String , session: Session): Retrofit? {
        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient(session))
                .build()
        return retrofit
    }

    fun getHttpClient(session: Session) : OkHttpClient {
        val interceptor = LoggingInterceptor(session)
        val interceptorHttp = HttpLoggingInterceptor()

        interceptorHttp.setLevel(HttpLoggingInterceptor.Level.BODY)

        val builder = OkHttpClient.Builder()
        builder.connectTimeout(Constants.TIME_OUT_CONNECTION.toLong(), TimeUnit.SECONDS) // connect timeout

        builder.addInterceptor(interceptor)
        builder.addInterceptor(interceptorHttp)

        val client = builder.build()

        return client
    }

}