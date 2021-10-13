package com.example.appupdatechecker

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.example.appupdatechecker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context
    private var version: String = ""

    companion object {
        private const val PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this@MainActivity
    }

    init{
        try {
            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            version = packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        binding.txtVersionName.text = version
    }

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

    private fun downloadUpdate() {
        // This @DownloadApk class is provided by our library
        // Pass the Context when creating object of DownloadApk
        val downloadApk = DownloadApk(this@MainActivity)

        // For starting download call the method startDownloadingApk() by passing the URL and the optional filename
        downloadApk.startDownloadingApk("https://github.com/Piashsarker/AndroidAppUpdateLibrary/blob/master/app-debug.apk")
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnUpdateApp -> {
                download()
            }
        }
    }
}