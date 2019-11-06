package com.tofaha.baseapp.dagger

import com.tofaha.baseapp.network.NetworkApi
import com.tofaha.baseapp.session.Session
import com.tofaha.baseapp.util.ApiUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ayoub on 3/24/18.
 */

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideNetwork(session: Session) : NetworkApi {
        return ApiUtils.networkApi(session)
    }

}