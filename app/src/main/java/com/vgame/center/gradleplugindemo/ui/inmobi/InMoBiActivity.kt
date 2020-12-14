package com.vgame.center.gradleplugindemo.ui.inmobi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vgame.center.gradleplugindemo.R
import kotlinx.android.synthetic.main.act_inmobi.*

/**
 * author: husy
 * date: 2020/12/14
 * email: husy@nemo-inc.com
 * des:
 */

class InMoBiActivity: AppCompatActivity() {

    companion object {
        @JvmStatic
        fun launch(context: Context?) {
            context?.startActivity(Intent(context, InMoBiActivity::class.java))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_inmobi)
        val inmobi = InmobiAdsAdapterFactory(this)
        val adapter = inmobi.createAdAdapter()

        act_inmobi_load?.setOnClickListener {
            adapter.requestAd(this)
        }

        act_inmobi_show?.setOnClickListener {
            adapter.showAd(this)
        }
    }


}