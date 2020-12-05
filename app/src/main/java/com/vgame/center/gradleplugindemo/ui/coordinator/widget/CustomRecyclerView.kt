package com.vgame.center.gradleplugindemo.ui.coordinator.widget

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

/**
 * author: husy
 * date: 2020/12/5
 * email: husy@nemo-inc.com
 * des:
 */

class CustomRecyclerView : RecyclerView {
    companion object {
        private const val TAG = "CustomRecyclerView"
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        println("onTouchEvent -> action: ${MotionEvent.actionToString(e!!.action)}")
        val res = super.onInterceptTouchEvent(e)
        println("onTouchEvent -> action: ${MotionEvent.actionToString(e!!.action)}, res: $res")
        return res
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTouchEvent(e: MotionEvent?): Boolean {
        println("onTouchEvent -> action: ${MotionEvent.actionToString(e!!.action)}")
        val res = super.onTouchEvent(e)
        println("onTouchEvent -> action: ${MotionEvent.actionToString(e!!.action)}, res: $res")
        return res
    }

    override fun dispatchNestedScroll(dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, offsetInWindow: IntArray?): Boolean {
        println("dispatchNestedScroll -> dxConsumed:$dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, offsetInWindow: $offsetInWindow")
        val res = super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow)
        println("dispatchNestedScroll -> dxConsumed:$dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, offsetInWindow: $offsetInWindow, res: $res")
        return res
    }

    override fun dispatchNestedScroll(dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, offsetInWindow: IntArray?, type: Int): Boolean {
        println("dispatchNestedScroll -> dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, offsetInWindow: $offsetInWindow, type: $type")
        val res = super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type)
        println("dispatchNestedScroll -> dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, offsetInWindow: $offsetInWindow, type: $type, res: $res")
        return res
    }

    override fun dispatchNestedPreScroll(dx: Int, dy: Int, consumed: IntArray?, offsetInWindow: IntArray?): Boolean {
        println("dispatchNestedPreScroll, dx: $dx, dy: $dy, consumed: $consumed, offsetInWindow: $offsetInWindow")
        val res = super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)
        println("dispatchNestedPreScroll, dx: $dx, dy: $dy, consumed: $consumed, offsetInWindow: $offsetInWindow, res: $res")
        return res
    }

    override fun dispatchNestedPreScroll(dx: Int, dy: Int, consumed: IntArray?, offsetInWindow: IntArray?, type: Int): Boolean {
        println("dispatchNestedPreScroll, dx: $dx, dy: $dy, consumed: $consumed, offsetInWindow: $offsetInWindow, type: $type")
        val res = super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type)
        println("dispatchNestedPreScroll, dx: $dx, dy: $dy, consumed: $consumed, offsetInWindow: $offsetInWindow, type: $type, res: $res")
        return res
    }

    override fun setNestedScrollingEnabled(enabled: Boolean) {
        super.setNestedScrollingEnabled(enabled)
        println("setNestedScrollingEnabled -> enable:$enabled")
    }

    private fun println(msg: String) {
        Log.i(TAG, msg)
    }
}