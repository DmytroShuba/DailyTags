package com.dmytroshuba.dailytags.markdown.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Headers {

    val h1: SpanStyle = SpanStyle(
        color = Color.Black,
        fontSize = 72.sp,
        fontWeight = FontWeight.W700
    )

    val h2: SpanStyle = SpanStyle(
        color = Color.Black,
        fontSize = 56.sp,
        fontWeight = FontWeight.W600
    )

    val h3: SpanStyle = SpanStyle(
        color = Color.Black,
        fontSize = 40.sp,
        fontWeight = FontWeight.W500
    )

    val h4: SpanStyle = SpanStyle(
        color = Color.Black,
        fontSize = 32.sp,
        fontWeight = FontWeight.W500
    )

    val h5: SpanStyle = SpanStyle(
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.W500
    )

    val h6: SpanStyle = SpanStyle(
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.W500
    )
}