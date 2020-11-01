package com.vgame.center.gradleplugindemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vgame.center.gradleplugindemo.R

/**
 * author: husy
 * date: 2020/7/17
 * email: husy@nemo-inc.com
 * des:
 */

class HListAdapter: RecyclerView.Adapter<HListAdapter.Vh>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
    }

    class Vh(view: View) : RecyclerView.ViewHolder(view) {

    }
}