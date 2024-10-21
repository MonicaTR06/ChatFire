package com.moni.chatfire.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.moni.chatfire.ui.HomeScreen
import com.moni.navigation.NavigatorGraphApi
import com.moni.navigation.routes.HomeRoute
import javax.inject.Inject

class HomeGraph @Inject constructor() : NavigatorGraphApi {

    override fun registerGraph(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<HomeRoute> {
            HomeScreen()
        }
    }
}
