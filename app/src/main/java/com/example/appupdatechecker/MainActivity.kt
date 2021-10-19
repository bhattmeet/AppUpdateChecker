package com.example.appupdatechecker

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.appupdatechecker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context
    private var version: String = ""

    companion object {
        private const val PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE = 1
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this@MainActivity

        try {
            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            version = packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        binding.txtVersionName.text = version
        binding.btnUpdateApp.setOnClickListener(this)
    }

    /**
     * This method is use for check write external storage permissions
     */
    private fun checkWriteExternalStoragePermission() {
        if (ActivityCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // If we have permission than we can Start the Download the update
            downloadUpdate()
        } else {
            //  If we don't have permission than requesting  the permission
            requestWriteExternalStoragePermission()
        }
    }

    /**
     * This method is use for request write external storage permissions from user
     */
    private fun requestWriteExternalStoragePermission() {
        if (ActivityCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE
            )
        } else {
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE
            )
        }
    }

    /**
     * This method is use for get permissions result
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE && grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            downloadUpdate()
        } else {
            Toast.makeText(this@MainActivity, "Permission Not Granted.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun download() {
        // First check the external storage permission
        checkWriteExternalStoragePermission()
    }

    /**
     * This method is use for download update
     */
    private fun downloadUpdate() {
        // Pass the Context of DownloadApk class when creating object of DownloadApk
        val downloadApk = DownloadApk(context)

        // For starting download call the method startDownloadingApk() by passing the URL and the optional filename
        downloadApk.startDownloadingApk("https://firebasestorage.googleapis.com/v0/b/appupdatechecker-93aae.appspot.com/o/AppUpdateChecker.apk?alt=media&token=5e5444e0-d53f-4c35-a3e0-86a7cca5b193")

        //For open play store when your app is in PlayStore
//        downloadApk.launchPlayStore()
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnUpdateApp -> {
                download()
            }
        }
    }
}