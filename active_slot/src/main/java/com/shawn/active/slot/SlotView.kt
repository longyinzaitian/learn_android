package com.shawn.active.slot

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

/**
 * author: husy
 * date: 2020/8/30
 * email: husy@nemo-inc.com
 * des:
 */

class SlotView: LinearLayout {

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

    }
}