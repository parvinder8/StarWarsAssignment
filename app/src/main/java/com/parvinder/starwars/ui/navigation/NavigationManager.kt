package com.parvinder.starwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.parvinder.starwars.ui.screens.matches.MatchScreen
import com.parvinder.starwars.ui.screens.pointTable.PointTableScreen

@Composable
fun NavigationManager(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.POINT_TABLE) {
        composable(Routes.POINT_TABLE) {
            PointTableScreen(navHostController = navHostController)
        }

        composable("${Routes.MATCH_LIST}/{characterId}") {
            it.arguments?.getString("characterId")?.let { x ->
                MatchScreen(navHostController = navHostController, id = x.toIntOrNull() ?: 0)
            }
        }

    }
}