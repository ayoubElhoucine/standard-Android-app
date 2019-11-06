package com.tofaha.baseapp.app

import android.os.Environment

/**
 * Created by ayoub on 3/19/18.
 */
interface Constants {

    companion object {

        val BASE_URL = "http://exemple.com"

        val REQUEST_IMAGE_CAPTURE = 1
        val TIME_OUT_CONNECTION = 10
        val PASSWORD = "password"
        val USER_NAME = "userName"
        val TOKEN = "token"
        val IP_ADDRESS = "ip_address"
        val LANGUAGE = "language"
        val FR = "fr"
        val EN = "en"
        val AR = "ar"

        val STORAGE_PERMISSION = 1
        val CAMERA_PERMISSION = 2
        val CONTACT_PERMISSION = 3
        val RECORD_PERMISSION = 4

        val ALL_PATIENTS = "all_patient"

        val IMAGE_MAX_SIZE = 500000
        val PATH_TEMP_FILE = Environment.getExternalStorageDirectory().toString() + "/TMMFOLDER"
        val QUALITY_IMAGE = 100
        val IMAGE_MAX_WIDTH = 1900

        val TIME_TO_REFRESH = 111

        val IMAGE_CAPTURE = 123

    }

}