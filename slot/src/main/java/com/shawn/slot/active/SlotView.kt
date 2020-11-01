package com.shawn.slot.active

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.shawn.slot.adapters.AbstractWheelAdapter

/**
 * author: husy
 * date: 2020/8/30
 * email: husy@nemo-inc.com
 * des:
 */

class SlotView: LinearLayout {

    private var mWheelAdapter: AbstractWheelAdapter? = null

    constructor(context: Context?) : super(context) {
        initView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    private fun initView(context: Context?) {
        orientation = VERTICAL
        val count = mWheelAdapter?.itemsCount
        count?.let {
            for (i in 0..it) {
                addView(mWheelAdapter?.getItem(i, null, this))
            }
        }
    }

    fun setWheelAdapter(wheelAdapter: AbstractWheelAdapter?) {
        mWheelAdapter = wheelAdapter
    }
}