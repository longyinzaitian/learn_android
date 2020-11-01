package com.vgame.center.gradleplugindemo.ui.coordinator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.vgame.center.gradleplugindemo.R
import com.vgame.center.gradleplugindemo.adapter.ListAdapter

/**
 * author: husy
 * date: 2020/11/1
 * email: husy@nemo-inc.com
 * des:
 */

class TestAppbarNoChildAct: AppCompatActivity() {
    companion object {
        @JvmStatic
        fun launch(context: Context?) {
            context?.startActivity(Intent(context, TestAppbarNoChildAct::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_test_appbar_no_child)

        val rcView = findViewById<RecyclerView>(R.id.test_appbar_no_child_list)
        rcView.adapter = ListAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}