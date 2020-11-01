package com.vgame.center.gradleplugindemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vgame.center.gradleplugindemo.R

/**
 * author: husy
 * date: 2020/6/27
 * email: husy@nemo-inc.com
 * des:
 */

class ListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        if (position == 5) {
            return 5
        }
        return super.getItemViewType(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.e("ListAdapter", "on create view holder. view type: $viewType")
        if (viewType == 5) {
            return Vh2(LayoutInflater.from(parent.context).inflate(R.layout.item_h_list, parent, false))
        }
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is Vh2) {
            holder.setInfo()
        }
    }

    class Vh(view: View) : RecyclerView.ViewHolder(view) {

    }

    class Vh2(view: View) : RecyclerView.ViewHolder(view) {
        private val recyclerView = view.findViewById<RecyclerView>(R.id.h_list_view)
        fun setInfo() {
            val lm = LinearLayoutManager(recyclerView.context)
            lm.orientation = LinearLayoutManager.HORIZONTAL
            recyclerView.layoutManager = lm
            recyclerView.adapter = HListAdapter()
        }
    }
}