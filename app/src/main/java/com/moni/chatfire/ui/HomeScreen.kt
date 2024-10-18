package com.moni.chatfire.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.chatfire.conversations.ui.ConversationsListPage
import com.chatfire.framework.utils.DevicePreviews
import com.moni.chatfire.R
import com.moni.chatfire.ui.components.ScreenTab
import com.moni.chatfire.ui.components.Tabs
import com.moni.chatfire.ui.components.MenuTopBar
import com.moni.chatfire.ui.models.ChatFireTab

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        tabs = getChatFireTabs(),
        pagerContent = { currentPage ->
            when (currentPage) {
                1 -> ConversationsListPage()
                else -> ScreenTab(currentPage.toString())
            }
        },
        onNewConversationClick = {
            viewModel.navigateToNewConversation()
        }
    )
}

@Composable
private fun HomeScreen(
    tabs: List<ChatFireTab>,
    pagerContent: @Composable PagerScope.(page: Int) -> Unit,
    onNewConversationClick: () -> Unit
) {
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { tabs.size })
    val selectedTabIndex = remember { mutableIntStateOf(1) }

    LaunchedEffect(key1 = selectedTabIndex.intValue) {
        pagerState.animateScrollToPage(selectedTabIndex.intValue)
    }

    LaunchedEffect(key1 = pagerState.currentPage) {
        selectedTabIndex.intValue = pagerState.currentPage
    }

    Scaffold(
        topBar = { MenuTopBar() },
        content = { innerPadding ->
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.padding(innerPadding),
                pageContent = pagerContent
            )
        },
        bottomBar = { Tabs(selectedTabIndex, tabs) },
        floatingActionButton = {
            FloatingActionButton(onClick = onNewConversationClick) {
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

@DevicePreviews
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        tabs = getChatFireTabs(),
        pagerContent = { currentPage ->
            ScreenTab(currentPage.toString())
        },
        onNewConversationClick = {}
    )
}
