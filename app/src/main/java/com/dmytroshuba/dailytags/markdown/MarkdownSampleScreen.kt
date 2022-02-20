package com.dmytroshuba.dailytags.markdown

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmytroshuba.dailytags.ShowcaseList
import com.dmytroshuba.dailytags.ShowcaseRoutes.MarkdownRoutes
import com.dmytroshuba.dailytags.markdown.elements.*
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.markdown.rules.MarkdownRules

@Composable
fun MarkdownScreen() {
    val navController = rememberNavController()
    val parser = SimpleMarkupParser()
    val rules = MarkdownRules.toList()

    NavHost(navController = navController, startDestination = "base") {
        composable("base") {
            ShowcaseList(
                MarkdownRoutes.values().map { it.value },
                navController::navigate
            )
        }
        composable(MarkdownRoutes.HEADERS.value) {
            HeadersScreen(parser, rules)
        }
        composable(MarkdownRoutes.EMPHASIS.value) {
            EmphasisScreen(parser, rules)
        }
        composable(MarkdownRoutes.LISTS.value) {
            ListsScreen(parser, rules)
        }
        composable(MarkdownRoutes.INLINE.value) {
            InlineScreen(parser, rules)
        }
        composable(MarkdownRoutes.LINKS.value) {
            LinksScreen(parser, rules)
        }
    }
}
