package com.chatfire.chat.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.chatfire.chat.R
import com.chatfire.chat.ui.components.ListOfMessages
import com.chatfire.chat.ui.components.SendMessageBox
import com.chatfire.chat.ui.model.Message
import com.chatfire.chat.ui.model.MessageContent
import com.chatfire.framework.ui.BackTopBar
import com.chatfire.framework.utils.DevicePreviews

@Composable
fun ChatScreen(
    chatId: String?,
    viewModel: ChatViewModel = hiltViewModel()
) {
    ChatScreen(onBack = { viewModel.back() })
}

@Composable
private fun ChatScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            BackTopBar(
                title = stringResource(R.string.chat_title, "Person"),
                onBackClick = onBack
            )
        },
        content = { paddingValues ->
            ListOfMessages(paddingValues = paddingValues, messages = demoFakeMessages())
        },
        bottomBar = {
            SendMessageBox {}
        }
    )
}

fun demoFakeMessages(): List<Message> {
    return listOf(
        Message(
            id = "1",
            senderName = "Alice",
            senderAvatar = "https://i.pravatar.cc/300?img=1",
            isMine = false,
            timestamp = "10:00",
            messageContent = MessageContent.TextMessage(
                message = "Hi, how are you?"
            )
        ),
        Message(
            id = "2",
            senderName = "Lucy",
            senderAvatar = "https://i.pravatar.cc/300?img=2",
            isMine = true,
            timestamp = "10:01",
            messageContent = MessageContent.TextMessage(
                message = "I'm good, thank you! And you?"
            )
        ),
        Message(
            id = "3",
            senderName = "Alice",
            senderAvatar = "https://i.pravatar.cc/300?img=1",
            isMine = false,
            timestamp = "10:02",
            messageContent = MessageContent.TextMessage(
                message = "Super fine!"
            )
        ),
        Message(
            id = "4",
            senderName = "Lucy",
            senderAvatar = "https://i.pravatar.cc/300?img=1",
            isMine = true,
            timestamp = "10:02",
            messageContent = MessageContent.TextMessage(
                message = "Are you going to the Kotlin conference?"
            )
        ),
        Message(
            id = "5",
            senderName = "Alice",
            senderAvatar = "https://i.pravatar.cc/300?img=1",
            isMine = false,
            timestamp = "10:03",
            messageContent = MessageContent.TextMessage(
                message = "Of course! I hope to see you there!"
            )
        ),
        Message(
            id = "5",
            senderName = "Alice",
            senderAvatar = "https://i.pravatar.cc/300?img=1",
            isMine = false,
            timestamp = "10:03",
            messageContent = MessageContent.TextMessage(
                message = "I'm going to arrive pretty early"
            )
        ),
        Message(
            id = "5",
            senderName = "Alice",
            senderAvatar = "https://i.pravatar.cc/300?img=1",
            isMine = false,
            timestamp = "10:03",
            messageContent = MessageContent.TextMessage(
                message = "So maybe we can have a coffee together"
            )
        ),
        Message(
            id = "5",
            senderName = "Alice",
            senderAvatar = "https://i.pravatar.cc/300?img=1",
            isMine = false,
            timestamp = "10:03",
            messageContent = MessageContent.TextMessage(
                message = "Wdyt?"
            )
        ),
    )
}

@DevicePreviews
@Composable
fun ChatScreenPreview() {
    ChatScreen(onBack = {})
}