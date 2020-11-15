package com.vgame.center.gradleplugindemo.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.OverScroller
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

/**
 * author: husy
 * date: 2020/11/15
 * email: husy@nemo-inc.com
 * des:
 */
class CustomBehavior : AppBarLayout.ScrollingViewBehavior {
    constructor() : super()
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, axes: Int): Boolean {
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes)
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        stopAppBarLayoutScroller(coordinatorLayout)
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }

    private fun stopAppBarLayoutScroller(coordinatorLayout: CoordinatorLayout) {
        try {
            val appBarView = coordinatorLayout.getChildAt(0) as AppBarLayout
            val appBarLp = appBarView.layoutParams as CoordinatorLayout.LayoutParams
            if (appBarLp.behavior != null) {
                stopBehaviorScroller(appBarLp.behavior as AppBarLayout.Behavior)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun stopBehaviorScroller(appBarBehavior: AppBarLayout.Behavior) {
        try {
            val filed = appBarBehavior.javaClass.superclass?.superclass?.getDeclaredField("scroller")
            if (filed != null) {
                filed.isAccessible = true
                val headerBehaviorScroller = filed.get(appBarBehavior)
                if (headerBehaviorScroller != null
                        && headerBehaviorScroller is OverScroller
                        && !headerBehaviorScroller.isFinished) {
                    headerBehaviorScroller.abortAnimation()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}