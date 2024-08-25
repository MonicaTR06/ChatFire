package com.moni.chatfire.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.chatfire.conversations.ui.ConversationsListScreen
import com.chatfire.framework.navigation.NavRoutes

@Composable
fun MainNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavRoutes.ConversationsList) {
        addConversationsList(navHostController)
    }
}

private fun NavGraphBuilder.addConversationsList(navHostController: NavHostController) {
    composable(NavRoutes.ConversationsList) {
        ConversationsListScreen(
            onNewConversationClick = {},
            onConversationClick = {}
        )
    }
}