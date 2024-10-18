package com.moni.chatfire.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.moni.chatfire.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = {
            IconButton(onClick = { /*TODO Menu action */ }) {
                Icon(Icons.Rounded.Menu, contentDescription = "Menu")
            }
        }
    )
}