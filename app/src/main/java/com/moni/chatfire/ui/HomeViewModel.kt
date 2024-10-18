package com.moni.chatfire.ui

import androidx.lifecycle.ViewModel
import com.moni.navigation.Navigator
import com.moni.navigation.routes.NewConversationRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun navigateToNewConversation() {
        return navigator.navigateTo(NewConversationRoute)
    }
}