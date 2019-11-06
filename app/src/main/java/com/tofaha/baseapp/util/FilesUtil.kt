package com.tofaha.baseapp.util

import android.os.Environment
import com.tofaha.baseapp.app.MyData
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object FilesUtil {

    fun homeDirectory() : File{
        val mediaStorageDir = File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "eScanny")

        if (!mediaStorageDir.exists()) {
            if (mediaStorageDir.mkdirs()){
                println("dir ===== " + mediaStorageDir.absolutePath)
            }else {
                println("can not create directory")
            }
        }

        return mediaStorageDir
    }

    fun patientDirectory(patientName : String) : File{
        var homeFile = homeDirectory()

        val patientFile = File(homeFile, patientName)

        if (!patientFile.exists()) {
            if (patientFile.mkdirs()){
                println("dir ===== " + patientFile.absolutePath)
            }else {
                println("can not create directory")
            }
        }

        return patientFile
    }

    fun createImageFile(patientName : String): File {

        var patientFile = patientDirectory(patientName)

        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        var file  = File(patientFile.path ,"IMG_" +timeStamp + "__" + ".jpg")
        println("the patient file path" + patientFile.absolutePath)
        println("the image file path" + file.absolutePath)
        return file

    }

    fun deleteFile(file : File) : Boolean{
        if (file.exists()){
            file.delete()
            return true
        }else {
            return true
        }
    }

}