package info.plateaukao.minbrowser.minwebview

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient

class MinWebViewClient(
    private val minWebView: MinWebView
) : WebViewClient() {

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        Log.d(TAG, "onPageStarted: $url")
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        Log.d(TAG, "onPageFinished: $url")
    }

    override fun onLoadResource(view: WebView?, url: String?) {
        super.onLoadResource(view, url)
        Log.d(TAG, "onLoadResource: $url")
    }

    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?
    ): WebResourceResponse? {
        Log.d(TAG, "shouldInterceptRequest: $request")
        return super.shouldInterceptRequest(view, request)
    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        minWebView.loadUrl(request?.url.toString())
        Log.d(TAG, "shouldOverrideUrlLoading: $request")
        return false
    }

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        minWebView.loadUrl(url ?: "")
        Log.d(TAG, "shouldOverrideUrlLoading: $url")
        return true
    }

    companion object {
        private const val TAG = "MinWebViewClient"
    }
}