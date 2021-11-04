package com.androidhans.lab12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //為按鈕設定監聽器
        findViewById<Button>(R.id.btn_start).setOnClickListener {
            //使用startService()方法啟動Service
            startService(Intent(this, MyService::class.java))
            Toast.makeText(this, "啟動Service", Toast.LENGTH_SHORT).show()
            //關閉Active
            finish()
        }
    }
}