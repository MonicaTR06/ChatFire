package com.moni.navigation

import androidx.navigation.NavHostController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor() {

    private lateinit var navHostController: NavHostController

    fun setNavHostController(navHostController: NavHostController) {
        this.navHostController = navHostController
    }

    fun navigateTo(route: Any) {
        navHostController.navigate(route = route) {
            launchSingleTop = true
        }
    }

    fun popUp(route: String) {
        navHostController.popBackStack(route, true)
    }

    fun popBackStack() {
        navHostController.popBackStack()
    }

    fun getCurrentRoute(): String {
        return navHostController.currentDestination?.route.orEmpty()
    }
}