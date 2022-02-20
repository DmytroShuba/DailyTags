package com.dmytroshuba.dailytags.demo

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.dmytroshuba.dailytags.core.simple.Node
import com.dmytroshuba.dailytags.core.simple.Rule
import java.util.regex.Pattern

class ColoredOrderedListRule(
    override val pattern: Pattern
): Rule(pattern) {

    override fun parse(): Node {
        return object: Node(PREFIX_UNORDERED_LIST + getMatchText(), decoration) {
            override fun render(builder: AnnotatedString.Builder) {
                val prefixStart = builder.length
                val prefixEnd = builder.length + PREFIX_UNORDERED_LIST.length
                builder.append(source)
                builder.addStyle(
                    SpanStyle(Color.Blue),
                    prefixStart,
                    prefixEnd
                )
            }
        }
    }

    companion object {
        private const val PREFIX_UNORDERED_LIST = "  ●  "
    }
}