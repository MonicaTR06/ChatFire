package com.moni.chatfire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.moni.chatfire.ui.navigation.MainNavigation
import com.moni.chatfire.ui.theme.ChatFireTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatFireTheme {
                val navHostController = rememberNavController()
                MainNavigation(navHostController = navHostController)
            }
        }
    }
}