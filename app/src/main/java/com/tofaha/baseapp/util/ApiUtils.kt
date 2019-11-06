package com.tofaha.baseapp.util

import com.tofaha.baseapp.app.Constants
import com.tofaha.baseapp.network.NetworkApi
import com.tofaha.baseapp.network.RetrofitClient
import com.tofaha.baseapp.session.Session


/**
 * Created by ayoub on 1/30/18.
 */

object ApiUtils {

    fun networkApi(session: Session) : NetworkApi {
        return RetrofitClient.getClient(Constants.BASE_URL , session)!!.create(NetworkApi::class.java)
    }

}