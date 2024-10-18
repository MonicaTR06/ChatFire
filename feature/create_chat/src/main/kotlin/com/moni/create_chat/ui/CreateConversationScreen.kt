package com.moni.create_chat.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.chatfire.framework.ui.BackTopBar
import com.chatfire.framework.utils.DevicePreviews
import com.moni.create_chat.R

@Composable
fun CreateConversationScreen(
    viewModel: CreateConversationViewModel = hiltViewModel()
) {
    CreateConversationScreen(
        onBack = { viewModel.back() }
    )
}

@Composable
private fun CreateConversationScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            BackTopBar(
                title = stringResource(R.string.create_chat_title),
                onBackClick = onBack
            )
        },
        content = { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(text = "New Conversation")
            }
        },
        bottomBar = {
        }
    )
}

@DevicePreviews
@Composable
fun ConversationListPreview() {
    CreateConversationScreen(onBack = {})
}