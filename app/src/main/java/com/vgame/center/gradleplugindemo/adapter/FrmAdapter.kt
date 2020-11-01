package com.vgame.center.gradleplugindemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * author: husy
 * date: 2020/6/27
 * email: husy@nemo-inc.com
 * des:
 */

class FrmAdapter(fm: FragmentManager, private val frmArray: Array<Fragment>): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return frmArray[position]
    }

    override fun getCount(): Int {
        return frmArray.size
    }
}