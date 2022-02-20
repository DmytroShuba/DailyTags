package com.dmytroshuba.dailytags.markdown.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import com.dmytroshuba.dailytags.core.simple.Decoration
import com.dmytroshuba.dailytags.core.simple.OnMatch

object Links {

    private val linkTextColor = Color(0xFF0000EE)

    val link: Decoration = Decoration(
        spanStyle = SpanStyle(
            color = linkTextColor,
            textDecoration = TextDecoration.Underline
        ),
        properties = mutableMapOf(),
    )

    val onMatch: OnMatch = { matcher, decoration ->
        val key = Properties.KEY_URL
        // Based on the current regex, 1st group contains text when 2nd has the link.
        val url = matcher.group(2)
        decoration.properties!![key] = url
        true
    }

    val onMatchHtml: OnMatch = { matcher, decoration ->
        val key = Properties.KEY_URL
        // Based on the current regex, 1st group contains text when 2nd has the link.
        val url = matcher.group(1)
        decoration.properties!![key] = url
        true
    }

    object Properties {
        const val KEY_URL = "URL"
    }
}