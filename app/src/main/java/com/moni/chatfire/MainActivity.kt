package com.moni.chatfire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.chatfire.chat.ui.navigation.ChatGraph
import com.moni.chatfire.ui.navigation.HomeGraph
import com.moni.chatfire.ui.theme.ChatFireTheme
import com.moni.create_chat.ui.navigation.CreateChatGraph
import com.moni.navigation.Navigator
import com.moni.navigation.NavigatorGraphApi
import com.moni.navigation.registerGraph
import com.moni.navigation.routes.HomeRoute
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var chatGraph: ChatGraph

    @Inject
    lateinit var createChatGraph: CreateChatGraph

    @Inject
    lateinit var homeGraph: HomeGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatFireTheme {
                ChatFireGraph(
                    navigator = navigator,
                    featureGraphs = arrayOf(homeGraph, chatGraph, createChatGraph),
                    startDestination = HomeRoute
                )
            }
        }
    }
}

@Composable
fun ChatFireGraph(
    navigator: Navigator,
    vararg featureGraphs: NavigatorGraphApi,
    startDestination: Any,
) {
    val navController = rememberNavController()
    navigator.setNavHostController(navController)

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        registerGraph(*featureGraphs)
    }
}
