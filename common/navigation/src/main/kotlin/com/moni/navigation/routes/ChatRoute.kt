package com.moni.navigation.routes

import kotlinx.serialization.Serializable

@Serializable
data class ChatRoute(val chatId: String) {
    companion object {
        const val deepLink = "https://chatfire.com/chat?chatId={chatId}"
    }
}