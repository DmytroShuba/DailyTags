package com.dmytroshuba.dailytags.core.simple

import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Creates an instance of Rule with the specified [Pattern].
 *
 * @param spanStyles a styling configuration for the a span that will match the pattern
 * @param paragraphStyles a styling configuration for a paragraph of a text that will match the pattern
 */
fun Pattern.toRule(spanStyles: SpanStyle? = null, paragraphStyles: ParagraphStyle? = null): Rule {
    return Rule(this, spanStyles, paragraphStyles)
}

/**
 * Creates an instance of Rule with the specified [Pattern].
 *
 * @param styling a pair of styling configurations for a text span that will match the pattern
 */
fun Pattern.toRule(styling: Pair<SpanStyle, ParagraphStyle>): Rule {
    return Rule(this, styling.first, styling.second)
}

/**
 * Creates an instance of Rule with the specified [Pattern].
 *
 * @param decoration
 */
fun Pattern.toRule(decoration: Decoration): Rule {
    return Rule(this, decoration)
}

/**
 * Creates an instance of Rule with the specified [Pattern] without styling.
 */
fun Pattern.toRule(): Rule {
    return Rule(this)
}

/**
 * Alias for onMatch callback function.
 * If the lambda returns false then the match is discarded.
 */
typealias OnMatch = ((matcher: Matcher, decoration: Decoration) -> Boolean)