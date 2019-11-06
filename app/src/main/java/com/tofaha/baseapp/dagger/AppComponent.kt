package com.tofaha.baseapp.dagger


import com.tofaha.baseapp.app.TofahaApplication
import com.tofaha.baseapp.superClasses.SuperActivity
import com.tofaha.baseapp.superClasses.SuperDialogFragment
import com.tofaha.baseapp.superClasses.SuperFragment
import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(AppModule::class , SessionModule::class
        , SubscriptionModule::class , NetworkModule::class))
interface AppComponent {

    fun inject(target : TofahaApplication)
    fun inject(target : SuperActivity)
    fun inject(target : SuperFragment)
    fun inject(target : SuperDialogFragment)

}
