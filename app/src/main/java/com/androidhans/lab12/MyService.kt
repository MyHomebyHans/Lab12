package com.androidhans.lab12

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {
    //僅在啟動時執行一次
    override fun onCreate() {
        super.onCreate()

    /* //每次啟動都會呼叫
    super.onStartCommand(intent, flags, startId)
    stopSelf()  //終止Service, 進入Service類別的onDestory()銷毀
    return super.onStartCommand(intent, flags, startId)
    */

        Thread { //使用Thread(執行緒)執行秏時任務
            try {
                Thread.sleep(3000) //延遲3秒
                //宣告Intent,從MyService敐動SecActivity
                val intent = Intent(this,SecActivity::class.java)
                //加入Flag旗標表示要產生一個新的Activity
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                }
            catch (e: InterruptedException) {
                e.printStackTrace()
            }
        } .start()
    }

    override fun onStartCommand (intent: Intent?, flags: Int, startId: Int): Int{

    return START_NOT_STICKY //Service終止後不再重啟

    /*
    return START_STICKY //Service終止後會嘗試重啟，並再次執行onStartCommand()但不會重傳Intent的資料
    return START_REDELIVER_INTENT  // Service終止後會嘗試重啟，並再次執行onStartCommand()且會重傳Intent的資料
     */
    }
    override fun onBind(intent: Intent): IBinder? = null
}