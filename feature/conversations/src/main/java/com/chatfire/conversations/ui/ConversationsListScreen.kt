package com.chatfire.conversations.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chatfire.conversations.ui.components.ConversationList
import com.chatfire.conversations.ui.components.demoFakeConversations

@Composable
fun ConversationsListScreen(
    onConversationClick: (chatId: String) -> Unit
) {
    ConversationList(
        conversations = demoFakeConversations(),
        onConversationClick = onConversationClick
    )
}

@Preview(showBackground = true)
@Composable
fun ConversationsListScreenPreview() {
    ConversationsListScreen({})
}

@Preview(showBackground = true, widthDp = 700, heightDp = 500)
@Composable
fun ConversationsListScreenPreviewTablet() {
    ConversationsListScreen({})
}

@Preview(showBackground = true, widthDp = 500, heightDp = 700)
@Composable
fun ConversationsListScreenPreviewTabletPortrait() {
    ConversationsListScreen({})
}