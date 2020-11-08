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
 * date: 2020/11/8
 * email: husy@nemo-inc.com
 * des:
 */

class CusViewGroup : LinearLayout {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("Touch-CusViewGroup", "dispatchTouchEvent ->${MotionEvent.actionToString(ev?.action ?: 0)}\"")
        val result = super.dispatchTouchEvent(ev)
        Log.i("Touch-CusViewGroup", "dispatchTouchEvent -> $result")
        return result
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("Touch-CusViewGroup", "onInterceptTouchEvent ->${MotionEvent.actionToString(ev?.action ?: 0)}\"")
        val result = super.onInterceptTouchEvent(ev)
        Log.i("Touch-CusViewGroup", "onInterceptTouchEvent -> $result")
        return result
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("Touch-CusViewGroup", "onTouchEvent ->${MotionEvent.actionToString(event?.action ?: 0)}\"")
        val result = super.onTouchEvent(event)
        Log.i("Touch-CusViewGroup", "onTouchEvent -> $result")
        return result
    }
}