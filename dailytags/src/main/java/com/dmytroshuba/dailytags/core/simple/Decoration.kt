package com.dmytroshuba.dailytags.core.simple

import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import java.util.regex.Matcher

/**
 * Decoration is a set of metadata and styling properties for a particular text content.
 *
 * @param spanStyle a styling configuration for a text span.
 * @param paragraphStyle a styling configuration for a paragraph.
 * @param properties metadata attached to the final AnnotatedString.
 */
data class Decoration(
    val spanStyle: SpanStyle? = null,
    val paragraphStyle: ParagraphStyle? = null,
    val properties: MutableMap<String, String>? = null
)