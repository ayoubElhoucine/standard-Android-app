package com.tofaha.baseapp.superClasses

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tofaha.baseapp.app.TofahaApplication
import com.tofaha.baseapp.network.NetworkApi
import com.tofaha.baseapp.session.Session
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by ayoub on 3/23/18.
 */
open class SuperFragment : Fragment() {

    @Inject
    lateinit var subscription : CompositeSubscription

    @Inject
    lateinit var networkApi : NetworkApi

    @Inject
    lateinit var session : Session

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (this.activity!!.application as TofahaApplication).getAppComponent()?.inject(this)

    }

}