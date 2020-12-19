package com.vgame.center.gradleplugindemo.ui.coordinator.widget

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

/**
 * author: husy
 * date: 2020/12/5
 * email: husy@nemo-inc.com
 * des:
 */

class CustomAppBarLayout: AppBarLayout {
    companion object {
        private const val TAG = "CustomAppBarLayout"
    }
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun getBehavior(): CoordinatorLayout.Behavior<AppBarLayout> {
        return CustomAppBarBehavior()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG, "onTouchEvent -> action: ${MotionEvent.actionToString(event!!.action)}")
        val res = super.onTouchEvent(event)
        Log.i(TAG, "onTouchEvent -> action: ${MotionEvent.actionToString(event!!.action)}, res: $res")
        return res
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.i(TAG, "onInterceptTouchEvent -> action: ${MotionEvent.actionToString(ev!!.action)}")
        val res = super.onInterceptTouchEvent(ev)
        Log.i(TAG, "onInterceptTouchEvent -> action: ${MotionEvent.actionToString(ev!!.action)}, res: $res")
        return res
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i(TAG,"dispatchTouchEvent -> action: ${MotionEvent.actionToString(ev!!.action)}")
        val res = super.dispatchTouchEvent(ev)
        Log.i(TAG,"dispatchTouchEvent -> action: ${MotionEvent.actionToString(ev!!.action)}, res: $res")
        return res
    }
}