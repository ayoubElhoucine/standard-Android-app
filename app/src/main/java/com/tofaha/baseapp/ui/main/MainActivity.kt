package com.tofaha.baseapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.tofaha.baseapp.R
import com.tofaha.baseapp.superClasses.SuperActivity



class MainActivity : SuperActivity() {

    @BindView(R.id.main_frame)
    lateinit var frame : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        replaceFragment()

    }

    fun replaceFragment(){
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.main_frame, MainFragment())
        transaction.addToBackStack(null)

        transaction.commit()
    }
}
