package fr.mguilbeaud.watchingreading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import fr.mguilbeaud.watchingreading.ui.theme.WatchingReadingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchingReadingTheme {
                MainScreen()
            }
        }
    }
}
