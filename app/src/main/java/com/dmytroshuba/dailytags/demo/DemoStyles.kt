package com.dmytroshuba.dailytags.demo

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.sp

object DemoStyles {

    val date: SpanStyle = SpanStyle(
        color = Color.Gray,
        fontSize = 10.sp
    )

    val highlightBlue = SpanStyle(
        background = Color.Blue.copy(alpha = 0.2f)
    )
}