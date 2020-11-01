package com.vgame.center.gradleplugindemo.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.shawn.slot.adapters.AbstractWheelAdapter
import com.vgame.center.gradleplugindemo.R

/**
 * author: husy
 * date: 2020/7/28
 * email: husy@nemo-inc.com
 * des:
 */

class SlotMachineAdapter(private val context: Context?, private val dataList: List<String>?) :
    AbstractWheelAdapter() {

    override fun getItemsCount(): Int {
        return if (dataList.isNullOrEmpty()) 0 else dataList.size
    }

    override fun getItem(
        index: Int,
        cachedView: View?,
        parent: ViewGroup?
    ): View? {
        val view: View = cachedView ?: View.inflate(context, R.layout.item_dialog_tiger_img, null)
        val img = view.findViewById<View>(R.id.iv_dialog_home_tiger) as ImageView
        when (index) {
            0 -> img.setImageResource(R.mipmap.ic_slot_1)
            1 -> img.setImageResource(R.mipmap.ic_slot_2)
            2 -> img.setImageResource(R.mipmap.ic_slot_3)
            3 -> img.setImageResource(R.mipmap.ic_slot_4)
            4 -> img.setImageResource(R.mipmap.ic_slot_5)
        }
        return view
    }
}