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
        println("dispatchNestedScroll -> dxConsumed:$dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, offsetInWindow: ${offsetInWindow?.get(0)}, ${offsetInWindow?.get(1)}")
        val res = super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow)
        println("dispatchNestedScroll -> dxConsumed:$dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, offsetInWindow: ${offsetInWindow?.get(0)}, ${offsetInWindow?.get(1)}, res: $res")
        return res
    }

    override fun dispatchNestedScroll(dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, offsetInWindow: IntArray?, type: Int): Boolean {
        println("dispatchNestedScroll -> dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, offsetInWindow: ${offsetInWindow?.get(0)}, ${offsetInWindow?.get(1)}, type: $type")
        val res = super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type)
        println("dispatchNestedScroll -> dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, offsetInWindow: ${offsetInWindow?.get(0)}, ${offsetInWindow?.get(1)}, type: $type, res: $res")
        return res
    }

    override fun dispatchNestedPreScroll(dx: Int, dy: Int, consumed: IntArray?, offsetInWindow: IntArray?): Boolean {
        println("dispatchNestedPreScroll, dx: $dx, dy: $dy, consumed: ${consumed?.get(0)}, ${consumed?.get(1)}, offsetInWindow: ${offsetInWindow?.get(0)}, ${offsetInWindow?.get(1)}")
        val res = super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)
        println("dispatchNestedPreScroll, dx: $dx, dy: $dy, consumed: ${consumed?.get(0)}, ${consumed?.get(1)}, offsetInWindow: ${offsetInWindow?.get(0)}, ${offsetInWindow?.get(1)}, res: $res")
        return res
    }

    override fun dispatchNestedPreScroll(dx: Int, dy: Int, consumed: IntArray?, offsetInWindow: IntArray?, type: Int): Boolean {
        println("dispatchNestedPreScroll, dx: $dx, dy: $dy, consumed: ${consumed?.get(0)}, ${consumed?.get(1)}, offsetInWindow: ${offsetInWindow?.get(0)}, ${offsetInWindow?.get(1)}, type: $type")
        val res = super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type)
        println("dispatchNestedPreScroll, dx: $dx, dy: $dy, consumed: ${consumed?.get(0)}, ${consumed?.get(1)}, offsetInWindow: ${offsetInWindow?.get(0)}, ${offsetInWindow?.get(1)}, type: $type, res: $res")
        return res
    }

    override fun startNestedScroll(axes: Int): Boolean {
        println("startNestedScroll axes: $axes")
        val res = super.startNestedScroll(axes)
        println("startNestedScroll. axes: $axes, res: $res")
        return res
    }

    override fun startNestedScroll(axes: Int, type: Int): Boolean {
        println("startNestedScroll. axes: $axes, type: $type")
        val res = super.startNestedScroll(axes, type)
        println("startNestedScroll. axes: $axes, type: $type, res: $res")
        return res
    }

    override fun stopNestedScroll() {
        println("stopNestedScroll")
        super.stopNestedScroll()
    }

    override fun stopNestedScroll(type: Int) {
        println("stopNestedScroll. type: $type")
        super.stopNestedScroll(type)
    }

    override fun dispatchNestedFling(velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        println("dispatchNestedFling. velocityX: $velocityX, velocityY: $velocityY, consumed: $consumed")
        val res = super.dispatchNestedFling(velocityX, velocityY, consumed)
        println("dispatchNestedFling. velocityX: $velocityX, velocityY: $velocityY, consumed: $consumed, res: $res")
        return res
    }

    override fun dispatchNestedPreFling(velocityX: Float, velocityY: Float): Boolean {
        println("dispatchNestedPreFling. velocityX: $velocityX, velocityY: $velocityY")
        val res = super.dispatchNestedPreFling(velocityX, velocityY)
        println("dispatchNestedPreFling. velocityX: $velocityX, velocityY: $velocityY, res: $res")
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