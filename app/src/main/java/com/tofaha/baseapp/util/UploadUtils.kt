package com.tofaha.baseapp.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ExifInterface
import com.tofaha.baseapp.app.Constants
import hugo.weaving.DebugLog
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.*

object UploadUtils {

    @DebugLog
    fun getRequestBody(path: String, typeImage: String, maxFileSize: Int): RequestBody {

        var exifOrientation: String? = null

        var oldExif: ExifInterface? = null
        try {
            oldExif = ExifInterface(path)
            exifOrientation = oldExif.getAttribute(ExifInterface.TAG_ORIENTATION)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val startTime = System.currentTimeMillis()

        var file = File(path)

        println("=========================== BEFORE ===========================")
        println("Name  : " + file.name)
        println("Path  : " + file.absolutePath)
        println("Size : " + humanReadableByteCount(file.length(), true))
        println("=========================== END ===========================")

        // On vérifie que ce n'est pas un gif
        if (!file.name.endsWith(".gif"))
            file = decodeFile(file, file.name, Constants.QUALITY_IMAGE, Constants.IMAGE_MAX_WIDTH, maxFileSize)

        println(exifOrientation)

        if (exifOrientation != null) {
            try {
                val newExif = ExifInterface(file.absolutePath)
                newExif.setAttribute(ExifInterface.TAG_ORIENTATION, exifOrientation)
                newExif.saveAttributes()

                println("test $exifOrientation")
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        val body = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(typeImage, file.name,
                        RequestBody.create(MediaType.parse("image/*"), file))
                .build()

        //val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
        //val body = MultipartBody.Part.createFormData("upload", file.name, reqFile)

        try {
            println(humanReadableByteCount(java.lang.Long.valueOf(file.length()), true))
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }

        val endTime = System.currentTimeMillis()

        println("That took resize " + (endTime - startTime) + " milliseconds " + file.name)
        //     System.out.println("That took " + ((endTime - startTime) / 1000) + " seconds");

        println("=========================== AFTER ===========================")
        println("Name  : " + file.name)
        println("Path  : " + file.absolutePath)
        println("Size : " + humanReadableByteCount(file.length(), true))
        println("=========================== END ===========================")

        return body
    }

    fun humanReadableByteCount(bytes: Long, si: Boolean): String {
        val unit = if (si) 1000 else 1024
        if (bytes < unit) return bytes.toString() + " B"
        val exp = (Math.log(bytes.toDouble()) / Math.log(unit.toDouble())).toInt()
        val pre = (if (si) "kMGTPE" else "KMGTPE")[exp - 1] + if (si) "" else "i"
        return String.format("%.1f %sB", bytes / Math.pow(unit.toDouble(), exp.toDouble()), pre)
    }

    @DebugLog
    private fun decodeFile(f: File, name: String, quality: Int, imageWidth: Int, maxFileSize: Int): File {

        var bitmap: Bitmap? = null

        if (f.length() <= maxFileSize)
            return f

        //Decode image size
        val o = BitmapFactory.Options()
        o.inJustDecodeBounds = true

        var fis: FileInputStream? = null
        var file: File? = null

        try {

            fis = FileInputStream(f)
            BitmapFactory.decodeStream(fis, null, o)
            //   fis.close();

            println("============= BREFORE =============")
            println("Height : " + o.outHeight)
            println("Width : " + o.outWidth)
            println("===================================")

            //Find the correct scale value. It should be the power of 2.
            var scale = 1

            if (o.outHeight > imageWidth || o.outWidth > imageWidth) {
                scale = Math.pow(2.0, Math.ceil(Math.log(imageWidth / Math.max(o.outHeight, o.outWidth).toDouble()) / Math.log(0.5)).toInt().toDouble()).toInt()
            }

            //Decode with inSampleSize
            val o2 = BitmapFactory.Options()
            o2.inSampleSize = scale
            o2.inScaled = false
            o2.inDither = false
            o2.inPreferredConfig = Bitmap.Config.ARGB_8888

            fis = FileInputStream(f)
            bitmap = BitmapFactory.decodeStream(fis, null, o2)



            println("============= AFTER =============")
            println(bitmap == null)
            println("Height : " + bitmap!!.height)
            println("Width : " + bitmap.width)
            println("===================================")
            //    fis.close();

            // Store to tmp file

            val mFolder = File(Constants.PATH_TEMP_FILE)
            if (!mFolder.exists()) {
                mFolder.mkdir()
            }

            file = File(mFolder.getAbsolutePath(), name)

            var fos: FileOutputStream? = null

            try {

                fos = FileOutputStream(file!!)

                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fos)


                fos.flush()
                fos.close()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: Exception) {

                e.printStackTrace()
            }



            bitmap.recycle()


        } catch (e: Throwable) {
        } finally {
            try {
                fis!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        /*
        try {
            System.out.println("AFTER ANALYSE " + file.length());
            System.out.println("constant " + Constants.IMAGE_MAX_SIZE);
            System.out.println(humanReadableByteCount(Constants.IMAGE_MAX_SIZE, true));
            System.out.println(humanReadableByteCount(Long.valueOf(file.length()), true));
        } catch (NullPointerException e) {
            e.printStackTrace();
        } */

        if (f.length() > Constants.IMAGE_MAX_SIZE)
            decodeFile(file!!, file.name, quality - 5, imageWidth - 200, maxFileSize)

        return file!!
    }

}