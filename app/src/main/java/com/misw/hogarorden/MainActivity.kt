package com.misw.hogarorden

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.misw.hogarorden.ui.theme.HogarOrdenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HogarOrdenTheme {
                AppNavigation()
            }
        }
    }
}
