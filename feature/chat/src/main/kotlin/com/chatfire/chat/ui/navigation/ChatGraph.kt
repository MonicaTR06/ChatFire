package com.chatfire.chat.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.chatfire.chat.ui.ChatScreen
import com.moni.navigation.NavigatorGraphApi
import com.moni.navigation.routes.ChatRoute
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatGraph @Inject constructor(): NavigatorGraphApi {

    override fun registerGraph(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<ChatRoute>() { backStackEntry ->
            val profile = backStackEntry.toRoute<ChatRoute>()
            ChatScreen(chatId = profile.chatId)
        }
    }

}