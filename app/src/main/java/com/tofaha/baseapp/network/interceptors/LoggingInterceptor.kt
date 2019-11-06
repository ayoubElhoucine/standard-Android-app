package com.tofaha.baseapp.network.interceptors

import com.tofaha.baseapp.app.MyData
import com.tofaha.baseapp.session.Session
import java.io.IOException
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by brio on 12/02/15.
 */
class LoggingInterceptor(private val session: Session) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()

        // add customize headers depends on url !

        if (original.url().toString().contains("api/users")){
            val requestBuilder = original.newBuilder()
                    .header("header name", "header value")

            val request = requestBuilder.build()
            return chain.proceed(request)

        }else {
            val requestBuilder = original.newBuilder()
                    .header("token", session.token)

            val request = requestBuilder.build()
            return chain.proceed(request)

        }

    }

    companion object {

        private val LIMIT_NUMBER_RETRY = 5

        private val TAG = "Retrofit" //LoggingInterceptor.class.getSimpleName();
    }

}