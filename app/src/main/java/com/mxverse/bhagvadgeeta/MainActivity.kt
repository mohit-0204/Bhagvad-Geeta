package com.mxverse.bhagvadgeeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mxverse.bhagvadgeeta.presentation.navigation.AppNavGraph
import com.mxverse.bhagvadgeeta.presentation.ui.theme.BhagvadGeetaTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BhagvadGeetaTheme {
                AppNavGraph()
            }
        }
    }
}