package com.vgame.center.gradleplugindemo.ui.web

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.vgame.center.gradleplugindemo.R


/**
 * author: husy
 * date: 2020/11/10
 * email: husy@nemo-inc.com
 * des:
 */

class WebActivity: AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context?) {
            context?.startActivity(Intent(context, WebActivity::class.java))
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_web)

        val mWebView = findViewById<WebView>(R.id.web_view)

        //重新加载 点击网页里面的链接还是在当前的webview里跳转。不跳到浏览器那边
        mWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return false
            }

            // 重写此方法能够让webview处理https请求
            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, error: SslError?) {
                handler.proceed()
            }

            override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {}
        }
        //支持js
        //支持js
        mWebView.settings.javaScriptEnabled = true
        // 解决图片不显示
        // 解决图片不显示
        mWebView.settings.blockNetworkImage = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            WebView.setWebContentsDebuggingEnabled(true)
        }

        //自适应屏幕
        mWebView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        mWebView.settings.loadWithOverviewMode = true

        //设置可以支持缩放
        mWebView.settings.setSupportZoom(false)
        //扩大比例的缩放
        //扩大比例的缩放
        mWebView.settings.useWideViewPort = false
        //设置是否出现缩放工具
        //设置是否出现缩放工具
        mWebView.settings.builtInZoomControls = false


        mWebView.loadUrl("http://static-www.gameschalo.com/endless-truck/index.html?pos=vid_lobby&browserType=2&ori=2")
    }
}