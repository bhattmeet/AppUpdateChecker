package com.example.appupdatechecker

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Environment
import android.util.Log
import android.webkit.URLUtil
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

/**
 * Created by piashsarker on 1/16/18, rewritten by Cyb3rKo on 12/21/20.
 */

class DownloadApk(var context: Context) : AppCompatActivity() {

    @JvmOverloads
    fun startDownloadingApk(url: String, fileName: String = getString(R.string.app_name)) {
        if (URLUtil.isValidUrl(url)) {
            DownloadNewVersion(context, url, fileName).execute()
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class DownloadNewVersion(
        val context: Context,
        val downloadUrl: String,
        val fileName: String
    ): AsyncTask<String, Int, Boolean>() {
        private lateinit var bar: ProgressDialog
        override fun onPreExecute() {
            super.onPreExecute()
            bar = ProgressDialog(context).apply {
                setCancelable(false)
                setMessage("Downloading...")
                isIndeterminate = true
                setCanceledOnTouchOutside(false)
                show()
            }
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            var msg = ""
            val progress = values[0]
            if (progress != null) {
                bar.progress = progress
                msg = if (progress > 99) "Finishing... " else "Downloading... $progress%"
            }

            bar.apply {
                isIndeterminate  = false
                max = 100
                setMessage(msg)
            }
        }

        override fun doInBackground(vararg p0: String?): Boolean {
            var flag = false

            try {
                val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/"
                val outputFile = File("$path$fileName.apk")
                while (outputFile.exists()) {
                    outputFile.delete()
                }

                val directory = File(path)
                if (!directory.exists()) {
                    directory.mkdirs()
                }

                val url = URL(downloadUrl)
                val c = url.openConnection() as HttpURLConnection
                c.requestMethod = "GET"
                c.connect()

                val fos = FileOutputStream(outputFile)
                val inputStream = c.inputStream
                val totalSize = c.contentLength.toFloat() //size of apk

                val buffer = ByteArray(1024)
                var len1: Int
                var per: Float
                var downloaded = 0f
                while (inputStream.read(buffer).also { len1 = it } != -1) {
                    fos.write(buffer, 0, len1)
                    downloaded += len1
                    per = (downloaded * 100 / totalSize)
                    publishProgress(per.toInt())
                }
                fos.close()
                inputStream.close()
                openNewVersion(outputFile.path)
                flag = true
            } catch (e: MalformedURLException) {
                Log.e("DownloadApk", "Update Error: " + e.message)
                flag = false
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return flag
        }

        override fun onPostExecute(result: Boolean?) {
            super.onPostExecute(result)
            Log.e("test","Result: $result")
            bar.dismiss()
            if (result!!) {
                Toast.makeText(context, "Update Done", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error: Try Again", Toast.LENGTH_SHORT).show()
            }
        }

        private fun openNewVersion(location: String) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                getUriFromFile(location),
                "application/vnd.android.package-archive"
            )
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            context.startActivity(intent)
        }

        private fun getUriFromFile(filePath: String): Uri {
            Log.e("test","Package Name: ${context.packageName}")
            return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                Log.e("test","File N: $filePath")
                Uri.fromFile(File(filePath))
            } else {
                Log.e("test","File: $filePath")
                FileProvider.getUriForFile(
                    context,
                    context.packageName + ".provider",
                    File(filePath)
                )
            }
        }
    }
}