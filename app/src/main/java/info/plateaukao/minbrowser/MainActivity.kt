package info.plateaukao.minbrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import info.plateaukao.minbrowser.minwebview.MinWebView
import info.plateaukao.minbrowser.ui.theme.MinBrowserTheme

class MainActivity : ComponentActivity() {
    private val webView: MinWebView by lazy { MinWebView(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinBrowserTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        NavigationBar(
                            onBack = { webView.goBack() },
                            onRefresh = { webView.reload() },
                            onForward = { webView.goForward() },
                        )
                        AndroidView(
                            factory = { webView },
                            modifier = Modifier.padding(2.dp),
                            update = { it.loadUrl("https://github.com/plateaukao/einkbro") }
                        )
                    }
                }
            }
        }
    }
}

// 三顆按鈕，用來返回，重新整理，與前進下個畫面
@Composable
fun NavigationBar(
    onBack: () -> Unit = {},
    onRefresh: () -> Unit = {},
    onForward: () -> Unit = {},
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = "back",
            modifier = Modifier.clickable { onBack() }
        )
        Icon(
            imageVector = Icons.Outlined.Refresh,
            contentDescription = "refresh",
            modifier = Modifier.clickable { onRefresh() },
        )
        Icon(
            imageVector = Icons.Outlined.ArrowForward,
            contentDescription = "forward",
            modifier = Modifier.clickable { onForward() },
        )
    }
}

@Preview
@Composable
fun NavigationBarPreview() {
    NavigationBar()
}