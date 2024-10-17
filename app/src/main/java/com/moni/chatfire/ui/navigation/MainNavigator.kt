package com.moni.chatfire.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.moni.chatfire.ui.MainScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavController.navigateToMain(navOptions: NavOptions) = navigate(route = HomeRoute, navOptions)

fun NavGraphBuilder.registerMainScreen(onConversationClick: (chatId: String) -> Unit) {
    composable<HomeRoute> {
        MainScreen(
            onNewConversationClick = {},
            onConversationClick = onConversationClick
        )
    }
}