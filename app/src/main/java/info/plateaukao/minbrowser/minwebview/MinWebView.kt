package info.plateaukao.minbrowser.minwebview

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebSettings
import android.webkit.WebView

class MinWebView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : WebView(context, attrs) {

    init {
        webViewClient = MinWebViewClient(this)
        webChromeClient = MinWebChromeClient()
        initWebSettings()

        // 讓 Chrome DevTools 可以連線
        setWebContentsDebuggingEnabled(true)

    }

    private fun initWebSettings() {
        with(settings) {
            domStorageEnabled = true
            databaseEnabled = true
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
    }
}