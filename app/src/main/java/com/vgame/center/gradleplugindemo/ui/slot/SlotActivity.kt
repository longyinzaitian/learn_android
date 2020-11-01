package com.vgame.center.gradleplugindemo.ui.slot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shawn.slot.OnWheelScrollListener
import com.shawn.slot.WheelView
import com.vgame.center.gradleplugindemo.R
import com.vgame.center.gradleplugindemo.adapter.SlotMachineAdapter
import kotlinx.android.synthetic.main.act_slot.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * author: husy
 * date: 2020/8/30
 * email: husy@nemo-inc.com
 * des:
 */

class SlotActivity: AppCompatActivity(), View.OnClickListener {

    private var mLastLeftNum = 1
    private var mLastCenterNum = 1
    private var mLastRightNum = 1

    companion object {
        private const val ANIM_TIME_LEFT = 5000
        private const val ANIM_TIME_CENTER = 6000
        private const val ANIM_TIME_RIGHT = 7000

        @JvmStatic
        fun launch(context: Context?) {
            context?.startActivity(Intent(context, SlotActivity::class.java))
        }
    }

    private val mScrollingListener = object :
            OnWheelScrollListener {
        override fun onScrollingStarted(wheel: WheelView?) {

        }

        override fun onScrollingFinished(wheel: WheelView?) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_slot)
        act_slot_start_btn?.setOnClickListener(this)
        val list = listOf("", "", "", "", "")
        initWheel(list)
    }

    private fun initWheel(list: List<String>) {
        initWheel(act_slot_left, list)
        initWheel(act_slot_center, list)
        initWheel(act_slot_right, list)
        act_slot_right?.addScrollingListener(mScrollingListener)
    }

    private fun initWheel(wheelView: WheelView?, list: List<String>) {
        wheelView?.viewAdapter = SlotMachineAdapter(this, list)
        wheelView?.visibleItems = 3
        wheelView?.isCyclic = true
        wheelView?.isEnabled = false
        wheelView?.setDrawShadows(false)
        wheelView?.setCurrentItem(list.size - 1, false)
    }

    fun startJustScroll() {
        justScrollWheel(act_slot_left)

        GlobalScope.launch(Dispatchers.Main) {
            delay(80L)
            justScrollWheel(act_slot_center)
        }
        GlobalScope.launch(Dispatchers.Main) {
            delay(160L)
            justScrollWheel(act_slot_right)
        }
    }

    fun startScroll(num: Int) {
        val numString = num.toString()
        val length = numString.length
        if (length == 3) {
            val c = numString[0]
            val firstNum = c.toString().toInt()
            mixWheel(act_slot_left, 50 + firstNum - mLastLeftNum, ANIM_TIME_LEFT)
            mLastLeftNum = firstNum
            val c1 = numString[1]
            val secondNum = c1.toString().toInt()
            mixWheel(act_slot_center, 70 + secondNum - mLastCenterNum, ANIM_TIME_CENTER)
            mLastCenterNum = secondNum
            val c2 = numString[2]
            val thirdNum = c2.toString().toInt()
            mixWheel(act_slot_right, 90 + thirdNum - mLastRightNum, ANIM_TIME_RIGHT)
            mLastRightNum = thirdNum
        }
    }

    private fun mixWheel(wheelView: WheelView?, round: Int, time: Int) {
        wheelView?.scroll(round, time)
    }

    private fun justScrollWheel(wheelView: WheelView?) {
        wheelView?.justScroll()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            act_slot_start_btn?.id -> startScroll(345)
        }
    }
}