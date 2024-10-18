package com.moni.chatfire.ui.components

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.chatfire.framework.utils.DevicePreviews
import com.moni.chatfire.ui.getChatFireTabs
import com.moni.chatfire.ui.models.ChatFireTab

@Composable
fun Tabs(
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

@DevicePreviews
@Composable
fun TabsPreview() {
    val selectedTabIndex = remember { mutableIntStateOf(1) }
    Tabs(selectedTabIndex, getChatFireTabs())
}