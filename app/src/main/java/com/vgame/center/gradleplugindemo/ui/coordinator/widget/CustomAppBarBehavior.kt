package com.vgame.center.gradleplugindemo.ui.coordinator.widget

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

/**
 * author: husy
 * date: 2020/12/5
 * email: husy@nemo-inc.com
 * des:
 */

class CustomAppBarBehavior : AppBarLayout.Behavior {
    companion object {
        private const val TAG = "CustomAppBarBehavior"
    }

    constructor() : super()
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: AppBarLayout, dependency: View): Boolean {
        println("onDependentViewChanged")
        return super.onDependentViewChanged(parent, child, dependency)
    }

    override fun onStartNestedScroll(parent: CoordinatorLayout, child: AppBarLayout, directTargetChild: View, target: View, nestedScrollAxes: Int, type: Int): Boolean {
        println("onStartNestedScroll , nestedScrollAxes: $nestedScrollAxes, type: $type")
        val res = super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type)
        println("onStartNestedScroll , nestedScrollAxes: $nestedScrollAxes, type: $type, res: $res")
        return res
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, directTargetChild: View, target: View, axes: Int): Boolean {
        println("onStartNestedScroll , axes: $axes")
        val res = super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes)
        println("onStartNestedScroll , axes: $axes, res: $res")
        return res
    }

    override fun onNestedScrollAccepted(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, directTargetChild: View, target: View, axes: Int) {
        println("onNestedScrollAccepted, axes:$axes")
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes)
    }

    override fun onNestedScrollAccepted(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, directTargetChild: View, target: View, axes: Int, type: Int) {
        println("onNestedScrollAccepted, axes: $axes, type:$type")
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type)
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, target: View) {
        println("onStopNestedScroll")
        super.onStopNestedScroll(coordinatorLayout, child, target)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        println("onNestedScroll, dxConsumed:$dxConsumed, dyConsumed:$dyConsumed, dxUnconsumed:$dxUnconsumed, dyUnconsumed:$dyUnconsumed")
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        println("onNestedScroll, dxConsumed:$dxConsumed, dyConsumed:$dyConsumed, dxUnconsumed:$dxUnconsumed, dyUnconsumed:$dyUnconsumed, type:$type")
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, abl: AppBarLayout, target: View, type: Int) {
        println("onStopNestedScroll -> type: $type")
        super.onStopNestedScroll(coordinatorLayout, abl, target, type)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
        println("onNestedScroll. dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, type: $type, consumed: ${consumed[0]}, ${consumed[1]}")
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed)
        println("onNestedScroll. dxConsumed: $dxConsumed, dyConsumed: $dyConsumed, dxUnconsumed: $dxUnconsumed, dyUnconsumed: $dyUnconsumed, type: $type, consumed: ${consumed[0]}, ${consumed[1]}")
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        println("onNestedPreScroll. dx: $dx, dy: $dy, consumed: ${consumed[0]}, ${consumed[1]}, type: $type")
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
        println("onNestedPreScroll. dx: $dx, dy: $dy, consumed: ${consumed[0]}, ${consumed[1]}, type: $type")
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, target: View, dx: Int, dy: Int, consumed: IntArray) {
        println("onNestedPreScroll, dx:$dx, dy:$dy, consumed:${consumed[0]}, ${consumed[1]}")
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed)
        println("onNestedPreScroll, dx:$dx, dy:$dy, consumed:${consumed[0]}, ${consumed[1]}")
    }

    override fun onNestedFling(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, target: View, velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        println("onNestedFling, velocityX:$velocityX, velocityY:$velocityY, consumed:$consumed")
        val res = super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed)
        println("onNestedFling, velocityX:$velocityX, velocityY:$velocityY, consumed:$consumed, res: $res")
        return res
    }

    override fun onNestedPreFling(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, target: View, velocityX: Float, velocityY: Float): Boolean {
        println("onNestedPreFling, velocityX:$velocityX, velocityY:$velocityY")
        val res = super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)
        println("onNestedPreFling, velocityX:$velocityX, velocityY:$velocityY, res: $res")
        return res
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onInterceptTouchEvent(parent: CoordinatorLayout, child: AppBarLayout, ev: MotionEvent): Boolean {
        println("onInterceptTouchEvent, action: ${MotionEvent.actionToString(ev!!.action)}")
        val res = super.onInterceptTouchEvent(parent, child, ev)
        println("onInterceptTouchEvent, action: ${MotionEvent.actionToString(ev!!.action)}, res: $res")
        return res
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTouchEvent(parent: CoordinatorLayout, child: AppBarLayout, ev: MotionEvent): Boolean {
        println("onTouchEvent, action: ${MotionEvent.actionToString(ev!!.action)}")
        val res = super.onTouchEvent(parent, child, ev)
        println("onTouchEvent, action: ${MotionEvent.actionToString(ev!!.action)}, res: $res")
        return res
    }

    private fun println(msg: String) {
        Log.i(TAG, msg)
    }
}