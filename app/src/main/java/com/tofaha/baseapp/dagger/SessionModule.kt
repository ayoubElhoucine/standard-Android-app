package com.tofaha.baseapp.dagger

import android.content.Context
import com.tofaha.baseapp.session.Session
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ayoub on 3/24/18.
 */

@Module
class SessionModule {

    @Singleton
    @Provides
    fun provideSession(context: Context) : Session {
        return Session(context)
    }

}