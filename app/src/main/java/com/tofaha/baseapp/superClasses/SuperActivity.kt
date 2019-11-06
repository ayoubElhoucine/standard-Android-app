package com.tofaha.baseapp.superClasses

import android.Manifest
import android.app.ProgressDialog
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.tofaha.baseapp.app.Constants
import com.tofaha.baseapp.app.TofahaApplication
import com.tofaha.baseapp.network.NetworkApi
import com.tofaha.baseapp.session.Session
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by ayoub on 3/23/18.
 */
open class SuperActivity : AppCompatActivity() {

    @Inject
    lateinit var subscription : CompositeSubscription

    @Inject
    lateinit var networkApi : NetworkApi

    @Inject
    lateinit var session : Session

    var permissionType : Int by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (this.application as TofahaApplication).getAppComponent()!!.inject(this)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            Constants.CAMERA_PERMISSION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (!checkForPermission(Constants.STORAGE_PERMISSION)){
                        askForPermission(Constants.STORAGE_PERMISSION)
                    }
                } else {

                }
                return
            }
        }
    }

    fun checkForPermission(arg : Int) : Boolean{
        when(arg){
            Constants.CAMERA_PERMISSION -> {
                permissionType = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)

                if (permissionType == PackageManager.PERMISSION_GRANTED){
                    return true
                }else {
                    return false
                }
            }
            Constants.STORAGE_PERMISSION -> {
                permissionType = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

                if (permissionType == PackageManager.PERMISSION_GRANTED){
                    return true
                }else {
                    return false
                }
            }else -> { return false }
        }
    }

    fun askForPermission(arg : Int){
        when(arg){
            Constants.CAMERA_PERMISSION -> {
                val permission = arrayOf(Manifest.permission.CAMERA)
                ActivityCompat.requestPermissions(this , permission , Constants.CAMERA_PERMISSION)
            }
            Constants.STORAGE_PERMISSION -> {
                val permission = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                ActivityCompat.requestPermissions(this , permission , Constants.STORAGE_PERMISSION)
            }
        }
    }
}