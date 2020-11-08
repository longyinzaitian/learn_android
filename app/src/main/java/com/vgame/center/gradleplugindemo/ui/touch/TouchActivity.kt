package com.vgame.center.gradleplugindemo.ui.touch

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.vgame.center.gradleplugindemo.R

/**
 * author: husy
 * date: 2020/11/8
 * email: husy@nemo-inc.com
 * des:
 */

class TouchActivity: AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context?) {
            context?.startActivity(Intent(context, TouchActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_test_touch)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("Touch-TouchActivity", "dispatchTouchEvent -> ${MotionEvent.actionToString(ev?.action?:0)}")
        val result = super.dispatchTouchEvent(ev)
        Log.i("Touch-TouchActivity", "dispatchTouchEvent -> $result")
        return result
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("Touch-TouchActivity", "onTouchEvent ->${MotionEvent.actionToString(event?.action ?: 0)}\"")
        val result = super.onTouchEvent(event)
        Log.i("Touch-TouchActivity", "onTouchEvent ->$result")
        return result
    }
}