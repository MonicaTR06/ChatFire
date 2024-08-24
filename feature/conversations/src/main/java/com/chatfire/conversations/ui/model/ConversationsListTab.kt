package com.chatfire.conversations.ui.model

import androidx.annotation.StringRes
import com.chatfire.conversations.R

data class ConversationsListTab(
    @StringRes
    val title: Int,
)

fun generateTabs(): List<ConversationsListTab> {
    return listOf(
        ConversationsListTab(
            title = R.string.conversations_tab_status_title,
        ),
        ConversationsListTab(
            title = R.string.conversations_tab_chats_title,
        ),
        ConversationsListTab(
            title = R.string.conversations_tab_calls_title,
        ),
    )
}
