package com.chatfire.conversations.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.chatfire.conversations.ui.components.ConversationList
import com.chatfire.conversations.ui.components.demoFakeConversations

@Composable
fun ConversationsListPage(
    viewModel: ConversationsListViewModel = hiltViewModel()
) {
    ConversationList(
        conversations = demoFakeConversations(),
        onConversationClick = { chatId ->
            viewModel.navigateToConversation(chatId)
        }
    )
}