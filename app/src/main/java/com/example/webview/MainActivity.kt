package com.example.webview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    lateinit var geekWebView: WebView
    lateinit var progressBar: ProgressBar
    private var isPageLoading = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar=findViewById(R.id.progressbar)
         geekWebView=findViewById(R.id.mainwebview)

        geekWebView.webViewClient=object: WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
               progressBar.visibility=View.VISIBLE
                isPageLoading = true
                disableUserInteraction()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility=View.GONE
                isPageLoading = false
                enableUserInteraction()
            }
        }

//        geekWebView.webViewClient= WebViewClient()
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
    private fun disableUserInteraction() {
        geekWebView.setOnTouchListener { _, _ -> true } // Disable touch events
        geekWebView.isClickable = false
        geekWebView.isFocusable = false
    }
    private fun enableUserInteraction() {
        geekWebView.setOnTouchListener(null) // Enable touch events
        geekWebView.isClickable = true
        geekWebView.isFocusable = true
    }
}