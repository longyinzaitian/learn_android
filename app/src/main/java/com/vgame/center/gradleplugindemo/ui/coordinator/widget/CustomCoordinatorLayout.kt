package com.vgame.center.gradleplugindemo.ui.coordinator.widget

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.coordinatorlayout.widget.CoordinatorLayout

/**
 * author: husy
 * date: 2020/12/5
 * email: husy@nemo-inc.com
 * des:
 */

class CustomCoordinatorLayout : CoordinatorLayout {
    companion object {
        private const val TAG = "CustomCoordLayout"
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun dispatchDependentViewsChanged(view: View) {
        println("dispatchDependentViewsChanged")
        super.dispatchDependentViewsChanged(view)
    }

    override fun onStartNestedScroll(child: View, target: View, nestedScrollAxes: Int): Boolean {
        println("onStartNestedScroll. nestedScrollAxes: $nestedScrollAxes")
        val res = super.onStartNestedScroll(child, target, nestedScrollAxes)
        println("onStartNestedScroll. nestedScrollAxes: $nestedScrollAxes, res: $res")
        return res
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        println("onStartNestedScroll. axes: $axes, type: $type")
        val res = super.onStartNestedScroll(child, target, axes, type)
        println("onStartNestedScroll. axes: $axes, type: $type, res: $res")
        return res
    }

    override fun onNestedScrollAccepted(child: View, target: View, nestedScrollAxes: Int) {
        println("onNestedScrollAccepted. nestedScrollAxes: $nestedScrollAxes")
        super.onNestedScrollAccepted(child, target, nestedScrollAxes)
    }

    override fun onNestedScrollAccepted(child: View, target: View, nestedScrollAxes: Int, type: Int) {
        println("onNestedScrollAccepted. nestedScrollAxes: $nestedScrollAxes, type: $type")
        super.onNestedScrollAccepted(child, target, nestedScrollAxes, type)
    }

    override fun onStopNestedScroll(target: View) {
        println("onStopNestedScroll")
        super.onStopNestedScroll(target)
    }

    override fun onStopNestedScroll(target: View, type: Int) {
        println("onStopNestedScroll, type: $type")
        super.onStopNestedScroll(target, type)
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        println("onNestedScroll. dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed")
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
        println("onNestedScroll. dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed")
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        println("onNestedScroll. dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, type: $type")
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
        println("onNestedScroll. dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, type: $type")
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
        println("onNestedScroll. dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, type: $type, consumed: ${consumed[0]}, ${consumed[1]}")
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed)
        println("onNestedScroll. dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, type: $type, consumed: ${consumed[0]}, ${consumed[1]}")
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
        println("onNestedPreScroll, dx: $dx, dy: $dy, consumed: ${consumed[0]}, ${consumed[1]}")
        super.onNestedPreScroll(target, dx, dy, consumed)
        println("onNestedPreScroll, dx: $dx, dy: $dy, consumed: ${consumed[0]}, ${consumed[1]}")
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        println("onNestedPreScroll, dx: $dx, dy: $dy, consumed: ${consumed[0]}, ${consumed[1]}, type: $type")
        super.onNestedPreScroll(target, dx, dy, consumed, type)
        println("onNestedPreScroll, dx: $dx, dy: $dy, consumed: ${consumed[0]}, ${consumed[1]}, type: $type")
    }

    override fun onNestedFling(target: View, velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        println("onNestedFling -> velocityX : $velocityX, velocityY: $velocityY, consumed: $consumed")
        val res = super.onNestedFling(target, velocityX, velocityY, consumed)
        println("onNestedFling -> velocityX : $velocityX, velocityY: $velocityY, consumed: $consumed, res: $res")
        return res
    }

    override fun onNestedPreFling(target: View, velocityX: Float, velocityY: Float): Boolean {
        println("onNestedPreFling -> velocityX: $velocityX, velocityY: $velocityY")
        val res = super.onNestedPreFling(target, velocityX, velocityY)
        println("onNestedPreFling -> velocityX: $velocityX, velocityY: $velocityY, res: $res")
        return res
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        println("onInterceptTouchEvent -> action: ${MotionEvent.actionToString(ev!!.action)}")
        val res = super.onInterceptTouchEvent(ev)
        println("onInterceptTouchEvent -> action: ${MotionEvent.actionToString(ev!!.action)}, res: $res")
        return res
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        println("onTouchEvent -> action: ${MotionEvent.actionToString(ev!!.action)}")
        val res = super.onTouchEvent(ev)
        println("onTouchEvent -> action: ${MotionEvent.actionToString(ev!!.action)}, res: $res")
        return res
    }

    private fun println(msg: String) {
        Log.i(TAG, msg)
    }
}