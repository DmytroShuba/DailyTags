package com.dmytroshuba.dailytags.markdown.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.sp

object Code {

    private val codeBlockBackgroundColor = Color(0xFFf6f8fa)
    private val inlineCodeBackground = Color(0xFFf3f3f3)

    val inline = SpanStyle(
        background = inlineCodeBackground,
        fontFamily = FontFamily.Monospace,
        fontSize = 12.sp
    )

    val blockOfCode = SpanStyle(
        background = codeBlockBackgroundColor,
        fontFamily = FontFamily.Monospace
    ) to ParagraphStyle(
        textIndent = TextIndent(3.sp)
    )
}