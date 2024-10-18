package com.chatfire.chat.ui

import androidx.lifecycle.ViewModel
import com.moni.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun back() {
        navigator.popBackStack()
    }

}