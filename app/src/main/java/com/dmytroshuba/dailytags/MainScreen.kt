package com.dmytroshuba.dailytags

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmytroshuba.dailytags.ShowcaseRoutes.MainRoutes
import com.dmytroshuba.dailytags.demo.DemoScreen
import com.dmytroshuba.dailytags.html.HtmlScreen
import com.dmytroshuba.dailytags.markdown.MarkdownScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "base") {
        composable("base") {
            val items = MainRoutes.values().map { it.value }
            ShowcaseList(items, navController::navigate)
        }
        composable(MainRoutes.DEMO.value) {
            DemoScreen()
        }
        composable(MainRoutes.MARKDOWN.value) {
            MarkdownScreen()
        }
        composable(MainRoutes.HTML.value) {
            HtmlScreen()
        }
    }
}