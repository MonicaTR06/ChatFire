package com.moni.chatfire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.moni.chatfire.ui.theme.ChatFireTheme
import com.moni.chatfire.navigation.HomeRoute
import com.moni.chatfire.navigation.registerMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatFireTheme {
                val navHostController = rememberNavController()
                ChatFireNavHost(navHostController)
            }
        }
    }
}

@Composable
fun ChatFireNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        registerMainScreen()
    }
}
