package com.tofaha.baseapp.dagger

import dagger.Module
import dagger.Provides
import rx.subscriptions.CompositeSubscription
import javax.inject.Singleton

/**
 * Created by ayoub on 3/24/18.
 */

@Module
class SubscriptionModule {

    @Provides
    fun provideCompositeSubscription(): CompositeSubscription {
        return CompositeSubscription()
    }

}