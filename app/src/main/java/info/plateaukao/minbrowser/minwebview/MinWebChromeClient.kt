package info.plateaukao.minbrowser.minwebview

import android.graphics.Bitmap
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView

class MinWebChromeClient: WebChromeClient() {
    override fun onHideCustomView() {
        super.onHideCustomView()
        Log.d(TAG, "onHideCustomView:")
    }

    override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
        super.onShowCustomView(view, callback)
        Log.d(TAG, "onShowCustomView")
    }

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        Log.d(TAG, "onProgressChanged: $newProgress")
    }

    override fun onReceivedTitle(view: WebView?, title: String?) {
        super.onReceivedTitle(view, title)
        Log.d(TAG, "onReceivedTitle: $title")
    }

    override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
        super.onReceivedIcon(view, icon)
        Log.d(TAG, "onReceivedIcon")
    }

    companion object {
        private const val TAG = "MinWebChromeClient"
    }

}