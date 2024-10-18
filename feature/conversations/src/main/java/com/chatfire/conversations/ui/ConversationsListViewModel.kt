package com.chatfire.conversations.ui

import androidx.lifecycle.ViewModel
import com.moni.navigation.Navigator
import com.moni.navigation.routes.ChatRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConversationsListViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun navigateToConversation(chatId: String) {
        return navigator.navigateTo(ChatRoute(chatId))
    }
}