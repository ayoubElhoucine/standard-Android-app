package com.tofaha.baseapp.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.tofaha.baseapp.R
import com.tofaha.baseapp.superClasses.SuperActivity
import com.tofaha.baseapp.util.MainUtil

class SplashActivity : SuperActivity() {

    @BindView(R.id.next_arrow)
    lateinit var next : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ButterKnife.bind(this)

        animateArrowForward(next)

    }

    @OnClick(R.id.next_layout)
    fun next(){
        MainUtil.startMainActivity(this)
    }

    fun animateArrowForward(arrow : View){
        YoYo.with(Techniques.BounceInRight).delay(1000).duration(1500).repeat(10).playOn(arrow)
    }

}
