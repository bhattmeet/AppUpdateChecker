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

class DownloadApk(var context: Context) : AppCompatActivity() {

    @JvmOverloads
    fun startDownloadingApk(url: String, fileName: String = "AppUpdateChecker") {
        if (URLUtil.isValidUrl(url)) {
            DownloadNewVersion(context, url, fileName).execute()
        }
    }

    /**
     * It's used to checks user device has Google Play Store installed
     */
    private fun isPlayStoreInstalled(): Boolean {
        val market = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=dummy"))
        val manager = context.packageManager
        val list = manager.queryIntentActivities(market, 0)
        if (list.size > 0) {
            for (i in list.indices) {
                if (list[i].activityInfo.packageName.startsWith("com.android.vending")) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * This method is use for launches your app's page in Google Play Store if it exist
     */
    fun launchPlayStore() {
        if (isPlayStoreInstalled()) {
            val marketPage = "market://details?id=" + context.packageName
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(marketPage)
            context.startActivity(intent)
        } else {
            Toast.makeText(context,"Google Play isn't installed on your device.",Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * This method is use for download new version
     */
    @SuppressLint("StaticFieldLeak")
    private class DownloadNewVersion(
        val context: Context,
        val downloadUrl: String,
        val fileName: String
    ) : AsyncTask<String, Int, Boolean>() {
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
                isIndeterminate = false
                max = 100
                setMessage(msg)
            }
        }

        override fun doInBackground(vararg p0: String?): Boolean {
            var flag = false

            try {
                val path =
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                        .toString() + "/"
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
            bar.dismiss()
            if (result!!) {
                Toast.makeText(context, "Update Done", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error: Try Again", Toast.LENGTH_SHORT).show()
            }
        }

        /**
         * This method is use for install new version of app
         */
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
            return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                Uri.fromFile(File(filePath))
            } else {
                FileProvider.getUriForFile(
                    context,
                    context.packageName + ".provider",
                    File(filePath)
                )
            }
        }
    }
}