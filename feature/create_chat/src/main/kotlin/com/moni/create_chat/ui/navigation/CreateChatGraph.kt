package com.moni.create_chat.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.moni.create_chat.ui.CreateConversationScreen
import com.moni.navigation.NavigatorGraphApi
import com.moni.navigation.routes.NewConversationRoute
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateChatGraph @Inject constructor() : NavigatorGraphApi {

    override fun registerGraph(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<NewConversationRoute> {
            CreateConversationScreen()
        }
    }
}