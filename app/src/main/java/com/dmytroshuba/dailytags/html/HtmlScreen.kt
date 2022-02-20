package com.dmytroshuba.dailytags.html

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmytroshuba.dailytags.ShowcaseList
import com.dmytroshuba.dailytags.ShowcaseRoutes.HtmlRoutes
import com.dmytroshuba.dailytags.html.elements.*
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.markdown.rules.HtmlRules

@Composable
fun HtmlScreen() {
    val navController = rememberNavController()
    val parser = SimpleMarkupParser()
    val rules = HtmlRules.toList()

    NavHost(navController = navController, startDestination = "base") {
        composable("base") {
            ShowcaseList(
                HtmlRoutes.values().map { it.value },
                navController::navigate
            )
        }
        composable(HtmlRoutes.HEADERS.value) {
            HeadersScreen(parser, rules)
        }
        composable(HtmlRoutes.EMPHASIS.value) {
            EmphasisScreen(parser, rules)
        }
        composable(HtmlRoutes.LISTS.value) {
            ListsScreen(parser, rules)
        }
        composable(HtmlRoutes.LINKS.value) {
            LinksScreen(parser, rules)
        }
    }
}
