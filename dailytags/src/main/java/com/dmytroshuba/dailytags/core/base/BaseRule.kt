package com.dmytroshuba.dailytags.core.base

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Rule determines how particular source must be found with the [pattern]
 * and what node it will be represented as after.
 *
 * @param pattern a representation of a regular expression.
 * @param matcher performs match operations on a character sequence by interpreting a Pattern.
 *
 * @see Pattern
 * @see Matcher
 */
abstract class BaseRule<N: BaseNode<N>> constructor(
    open val pattern: Pattern,
    open val matcher: Matcher
) {
    /**
     * Attempts to find the next CharSequence that matches the pattern.
     */
    open fun match(source: CharSequence): Boolean {
        matcher.reset(source)
        return matcher.find()
    }

    /**
     * Returns the matched text.
     */
    abstract fun getMatchText(): String

    /**
     * Returns the Node containing the matched content.
     */
    abstract fun parse(): N
}