package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    lateinit var geekWebView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         geekWebView=findViewById(R.id.mainwebview)
        geekWebView.webViewClient= WebViewClient()
        geekWebView.loadUrl("https://www.geeksforgeeks.org/")
        geekWebView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        geekWebView.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {
        if (geekWebView.canGoBack()) {
            geekWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}