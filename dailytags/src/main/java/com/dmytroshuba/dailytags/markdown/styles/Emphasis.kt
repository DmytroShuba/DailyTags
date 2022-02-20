package com.dmytroshuba.dailytags.markdown.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

object Emphasis {

    val bold = SpanStyle(
        fontWeight = FontWeight.Bold
    )

    val italic = SpanStyle(
        fontStyle = FontStyle.Italic
    )

    val strikeThrough = SpanStyle(
        textDecoration = TextDecoration.LineThrough
    )

    // mark tag in HTML
    val highlight = SpanStyle(
        background = Color.Yellow
    )
}