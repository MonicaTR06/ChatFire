package com.moni.navigation

import androidx.navigation.NavGraphBuilder

interface NavigatorGraphApi {
    fun registerGraph(navGraphBuilder: NavGraphBuilder)
}

fun NavGraphBuilder.registerGraph(vararg navigatorApis: NavigatorGraphApi) {
    navigatorApis.forEach { navigatorApi ->
        navigatorApi.registerGraph(navGraphBuilder = this)
    }
}