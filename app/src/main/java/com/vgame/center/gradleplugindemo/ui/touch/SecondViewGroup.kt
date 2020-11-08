package com.vgame.center.gradleplugindemo.ui.touch

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.annotation.RequiresApi

/**
 * author: husy
 * date: 2020/11/9
 * email: husy@nemo-inc.com
 * des:
 */

class SecondViewGroup : LinearLayout {
    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("Touch-SecondViewGroup", "dispatchTouchEvent ->${MotionEvent.actionToString(ev?.action ?: 0)}\"")
        val result = super.dispatchTouchEvent(ev)
        Log.i("Touch-SecondViewGroup", "dispatchTouchEvent -> $result")
        return result
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("Touch-SecondViewGroup", "onInterceptTouchEvent ->${MotionEvent.actionToString(ev?.action ?: 0)}\"")
        val result = super.onInterceptTouchEvent(ev)
        Log.i("Touch-SecondViewGroup", "onInterceptTouchEvent -> $result")
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            return false
        }
        return true
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("Touch-SecondViewGroup", "onTouchEvent ->${MotionEvent.actionToString(event?.action ?: 0)}\"")
        val result = super.onTouchEvent(event)
        Log.i("Touch-SecondViewGroup", "onTouchEvent -> $result")
        return true
    }
}