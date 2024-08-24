package com.chatfire.conversations.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chatfire.conversations.R
import com.chatfire.conversations.ui.components.ConversationList
import com.chatfire.conversations.ui.components.demoFakeConversations
import com.chatfire.conversations.ui.model.generateTabs

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ConversationsListScreen(
    onNewConversationClick: () -> Unit,
    onConversationClick: (chatId: String) -> Unit
) {
    val tabs = generateTabs()
    val selectedTabIndex = remember { mutableIntStateOf(1) }
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { tabs.size })

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.conversations_list_title)) },
                actions = {
                    IconButton(onClick = { /*TODO Menu action */ }) {
                        Icon(Icons.Rounded.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        content = { innerPadding ->
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.padding(innerPadding)
            ) { index ->
                when (index) {
                    0 -> {
                        //Status
                    }

                    1 -> {
                        ConversationList(
                            conversations = demoFakeConversations(),
                            onConversationClick = onConversationClick
                        )
                    }

                    2 -> {
                        // Calls
                    }
                }

                LaunchedEffect(key1 = selectedTabIndex.intValue) {
                    pagerState.animateScrollToPage(selectedTabIndex.intValue)
                }
            }
        },
        bottomBar = {
            TabRow(selectedTabIndex = selectedTabIndex.intValue) {
                tabs.forEachIndexed { index, _ ->
                    Tab(
                        text = { Text(text = stringResource(id = tabs[index].title)) },
                        selected = (index == selectedTabIndex.intValue),
                        onClick = {
                            selectedTabIndex.intValue = index
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onNewConversationClick() }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ConversationsListScreenPreview() {
    ConversationsListScreen({}, {})
}

@Preview(showBackground = true, widthDp = 700, heightDp = 500)
@Composable
fun ReplyAppPreviewTablet() {
    ConversationsListScreen({}, {})
}

@Preview(showBackground = true, widthDp = 500, heightDp = 700)
@Composable
fun ReplyAppPreviewTabletPortrait() {
    ConversationsListScreen({}, {})
}