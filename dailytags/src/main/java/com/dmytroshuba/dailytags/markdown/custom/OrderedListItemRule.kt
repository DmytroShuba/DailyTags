package com.dmytroshuba.dailytags.markdown.custom

import androidx.compose.ui.text.SpanStyle
import com.dmytroshuba.dailytags.core.simple.Node
import com.dmytroshuba.dailytags.core.simple.Decoration
import com.dmytroshuba.dailytags.core.simple.Rule
import java.util.regex.Pattern

class OrderedListItemRule(override val pattern: Pattern,
                              override val decoration: Decoration
): Rule(pattern, decoration) {

    constructor(pattern: Pattern, spanStyle: SpanStyle): this(pattern, Decoration(spanStyle))

    private var itemCounter = COUNTER_DEFAULT_VALUE

    override fun parse(): Node {
        val prefix = PREFIX_ORDERED_LIST.format(itemCounter++)
        return Node(prefix + getMatchText(), decoration)
    }

    override fun match(source: CharSequence): Boolean {
        matcher.reset(source)
        return when (matcher.find()) {
            true -> onMatch(matcher, decoration)
            false -> {
                reset()
                false
            }
        }
    }

    private fun reset() {
        itemCounter = COUNTER_DEFAULT_VALUE
    }

    companion object {
        private const val COUNTER_DEFAULT_VALUE = 1
        private const val PREFIX_ORDERED_LIST = "  %d.  "
    }
}