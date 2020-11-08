package com.vgame.center.gradleplugindemo.ui.touch

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi

/**
 * author: husy
 * date: 2020/11/8
 * email: husy@nemo-inc.com
 * des:
 */

class InnerView: View {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.i("Touch-InnerView", "dispatchTouchEvent ->${MotionEvent.actionToString(event?.action ?: 0)}\"")
        val result = super.dispatchTouchEvent(event)
        Log.i("Touch-InnerView", "dispatchTouchEvent -> $result")
        return result
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("Touch-InnerView", "onTouchEvent ->${MotionEvent.actionToString(event?.action ?: 0)}\"")
        val result = super.onTouchEvent(event)
        Log.i("Touch-InnerView", "onTouchEvent -> $result")
        return true
    }
}