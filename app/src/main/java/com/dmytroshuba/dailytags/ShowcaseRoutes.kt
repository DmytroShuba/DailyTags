package com.dmytroshuba.dailytags

sealed class ShowcaseRoutes {

    enum class MainRoutes(val value: String) {
        DEMO("Demo"),
        MARKDOWN("Markdown"),
        HTML("Html")
    }

    enum class MarkdownRoutes(val value: String) {
        HEADERS("Headers"),
        EMPHASIS("Emphasis"),
        INLINE("Inline"),
        LISTS("Lists"),
        LINKS("Links")
    }

    enum class HtmlRoutes(val value: String) {
        HEADERS("Headers"),
        EMPHASIS("Emphasis"),
        LISTS("Lists"),
        LINKS("Links")
    }
}