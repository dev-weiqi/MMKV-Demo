package dev.weiqi.mmkv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val localData = LocalData(applicationContext)
        localData.username = "Joseph Wang"
        localData.isLogin = true

        Log.d("MMKV", "username: ${localData.username}")
        Log.d("MMKV", "isLogin: ${localData.isLogin}")
    }
}
