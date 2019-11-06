package com.tofaha.baseapp.app

import android.content.res.Configuration
import android.os.Build
import androidx.multidex.MultiDexApplication
import com.tofaha.baseapp.dagger.AppComponent
import com.tofaha.baseapp.dagger.AppModule
import com.tofaha.baseapp.dagger.DaggerAppComponent
import com.tofaha.baseapp.session.Session
import java.util.*
import javax.inject.Inject

/**
 * Created by ayoub on 12/3/17.
 */
class TofahaApplication : MultiDexApplication() {

    @Inject
    lateinit var session: Session

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        MyData.application = this
        appComponent = initDagger(this)
        getAppComponent()!!.inject(this)
        setPreferedLanguage()
    }

    fun initDagger(application: TofahaApplication): AppComponent {
        return DaggerAppComponent.builder().appModule(AppModule(application)).build()
    }

    fun getAppComponent(): AppComponent? {
        return this.appComponent
    }

    fun setPreferedLanguage() {
        val config = getBaseContext().getResources().getConfiguration()
        var language = session!!.language

        if (language == null)
            language = Locale.getDefault().language

        val preferredLocale = Locale(language!!)

        if (preferredLocale.language != Locale.getDefault().language) {
            Locale.setDefault(preferredLocale)
            config.locale = preferredLocale
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics())
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {

        if (session!!.language != null && newConfig.locale.language != session!!.language) {
            super.onConfigurationChanged(newConfig)
            // ugly fix ! On devices after 4.0 screen is blinking when you rotate device!
            if (Build.VERSION.SDK_INT < 14) {
                newConfig.locale = Locale(session!!.language)
            }
            baseContext.resources.updateConfiguration(newConfig, baseContext.resources.displayMetrics)
            Locale.setDefault(Locale(session!!.language))
        } else {
            super.onConfigurationChanged(newConfig)
        }
    }

}

