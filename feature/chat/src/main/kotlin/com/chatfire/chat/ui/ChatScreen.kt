package com.chatfire.chat.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chatfire.chat.R
import com.chatfire.chat.ui.components.MessageItem
import com.chatfire.chat.ui.components.SendMessageBox
import com.chatfire.chat.ui.model.Message
import com.chatfire.chat.ui.model.MessageContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    chatId: String?,
    onBack: () -> Unit
) {

    val messages = demoFakeMessages()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.chat_title, "Person"))
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
                    }
                },
            )
        },
        bottomBar = {
            SendMessageBox {}
        }
    ) { paddingValues->
        ListOfMessages(paddingValues = paddingValues, messages = messages)
    }

}

@Composable
fun ListOfMessages(messages: List<Message>, paddingValues: PaddingValues) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(messages) { message ->
                    MessageItem(message = message)
                }
            }
        }
    }
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

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen(null, {})
}

@Preview(showBackground = true, widthDp = 700, heightDp = 500)
@Composable
fun ChatScreenPreviewTablet() {
    ChatScreen(null, {})
}

@Preview(showBackground = true, widthDp = 500, heightDp = 700)
@Composable
fun ChatScreenPreviewTabletPortrait() {
    ChatScreen(null, {})
}