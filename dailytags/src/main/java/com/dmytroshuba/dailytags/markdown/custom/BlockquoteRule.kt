package com.dmytroshuba.dailytags.markdown.custom

import androidx.compose.ui.text.SpanStyle
import com.dmytroshuba.dailytags.core.simple.Node
import com.dmytroshuba.dailytags.core.simple.Decoration
import com.dmytroshuba.dailytags.core.simple.Rule
import java.util.regex.Pattern

class BlockquoteRule(
    override val pattern: Pattern,
    override val decoration: Decoration
) : Rule(pattern, decoration) {

    constructor(pattern: Pattern, spanStyle: SpanStyle): this(pattern, Decoration(spanStyle))

    override fun parse(): Node {
        return Node(PREFIX_BLOCKQUOTE + getMatchText(), decoration)
    }

    companion object {
        private const val PREFIX_BLOCKQUOTE = "   ▍   "
    }
}