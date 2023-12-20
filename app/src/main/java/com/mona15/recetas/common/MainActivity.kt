package com.mona15.recetas.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.mona15.recetas.ui.theme.RecetasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecetasTheme {

                var loadingSplashScreen by remember {
                    mutableStateOf(true)
                }

                Navigation(
                    isLoading = { loadingSplashScreen = it },
                    loadingSplashScreen = loadingSplashScreen
                )
            }
        }
    }
}