package com.moni.chatfire.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chatfire.conversations.ui.components.ConversationList
import com.chatfire.conversations.ui.components.demoFakeConversations
import com.moni.chatfire.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNewConversationClick: () -> Unit,
    onConversationClick: (chatId: String) -> Unit
) {
    val tabs = getChatFireTabs()
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { tabs.size })
    val selectedTabIndex = remember { mutableIntStateOf(1) }

    LaunchedEffect(key1 = selectedTabIndex.intValue) {
        pagerState.animateScrollToPage(selectedTabIndex.intValue)
    }

    LaunchedEffect(key1 = pagerState.currentPage) {
        selectedTabIndex.intValue = pagerState.currentPage
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
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
            ) { currentPage ->
                when (currentPage) {
                    0 -> {
                        ScreenTab(currentPage.toString())
                    }

                    1 -> {
                        ConversationList(
                            conversations = demoFakeConversations(),
                            onConversationClick = { chatId ->

                            }
                        )
                    }

                    2 -> {
                        ScreenTab(currentPage.toString())
                    }
                }
            }
        },
        bottomBar = {
            ChatFireTabRow(selectedTabIndex, tabs)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onNewConversationClick() }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        }
    )
}

fun getChatFireTabs(): List<ChatFireTab> {
    return listOf(
        ChatFireTab(
            title = R.string.home_tab_status_title,
        ),
        ChatFireTab(
            title = R.string.home_tab_chats_title,
        ),
        ChatFireTab(
            title = R.string.home_tab_calls_title,
        ),
    )
}

@Composable
private fun ChatFireTabRow(
    selectedTabIndex: MutableIntState,
    tabs: List<ChatFireTab>
) {
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
}

@Composable
fun ScreenTab(pageNumber: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = pageNumber
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MainScreen({}, {})
}

@Preview(showBackground = true, widthDp = 700, heightDp = 500)
@Composable
fun HomeScreenPreviewTablet() {
    MainScreen({}, {})
}

@Preview(showBackground = true, widthDp = 500, heightDp = 700)
@Composable
fun HomeScreenPreviewTabletPortrait() {
    MainScreen({}, {})
}