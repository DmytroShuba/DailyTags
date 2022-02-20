package com.dmytroshuba.dailytags.core.simple

import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import com.dmytroshuba.dailytags.core.base.exception.ParseException
import com.dmytroshuba.dailytags.core.base.BaseRule
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Rule determines how particular source must be found with the [pattern]
 * and what node it will be represented as after.
 *
 * @param pattern a representation of a regular expression.
 * @param decoration styles and properties that will be added
 * to the the Node containing source that matches the pattern.
 * @param matcher performs match operations on a character sequence by interpreting a Pattern.
 *
 * @see Pattern
 * @see Decoration
 * @see Matcher
 */
open class Rule private constructor(
    override val pattern: Pattern,
    open val decoration: Decoration,
    override val matcher: Matcher
) : BaseRule<Node>(pattern, matcher) {

    constructor(
        pattern: Pattern,
        decoration: Decoration
    ) : this(
        pattern,
        decoration,
        pattern.matcher("")
    )

    constructor(
        pattern: Pattern,
        spanStyles: SpanStyle? = null,
        paragraphStyles: ParagraphStyle? = null,
        properties: MutableMap<String, String>? = null
    ) : this(
        pattern,
        Decoration(spanStyles, paragraphStyles, properties),
        pattern.matcher("")
    )

    protected var customGroup: Int? = null

    protected var onMatch: OnMatch = { _, _ -> true }

    override fun match(source: CharSequence): Boolean {
        matcher.reset(source)
        return when (matcher.find()) {
            true -> onMatch(matcher, decoration)
            false -> false
        }
    }

    override fun getMatchText(): String {
        val group = customGroup ?: matcher.groupCount()
        return matcher.group(group)
            ?: throw ParseException("Group cannot be extracted from matched text. Group: $group")
    }

    override fun parse(): Node {
        return Node(getMatchText(), decoration)
    }

    companion object {

        /**
         * Applies custom settings to the rule.
         *
         * @param groupIndex the index of a capturing group in the match. The number of groups depends on the regular expression.
         * For example "# Header 1" has 2 groups: "# Header" and "Header".
         * By default, the max group is used to return the final text. However, to return a different capture change group index.
         * @param onMatch callback that is triggered when
         */
        fun Rule.applyCustomSettings(
            groupIndex: Int? = null,
            onMatch: OnMatch? = null
        ): Rule {
            this.customGroup = groupIndex
            onMatch?.let { this.onMatch = it }
            return this
        }
    }
}