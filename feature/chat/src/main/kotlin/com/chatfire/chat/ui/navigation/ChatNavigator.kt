package com.chatfire.chat.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.chatfire.chat.ui.ChatScreen
import kotlinx.serialization.Serializable


@Serializable
data class ChatRoute(val chatId: String? = null)

fun NavController.navigateToChat(chatId: String, navOptions: NavOptions? = null) {
    navigate(ChatRoute(chatId), navOptions)
}

fun NavGraphBuilder.registerChatScreen(onBack: () -> Unit) {
    composable<ChatRoute>() { backStackEntry ->
        val profile = backStackEntry.toRoute<ChatRoute>()
        ChatScreen(chatId = profile.chatId, onBack)
    }
}