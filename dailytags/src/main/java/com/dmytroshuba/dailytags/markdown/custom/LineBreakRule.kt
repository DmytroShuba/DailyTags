package com.dmytroshuba.dailytags.markdown.custom

import com.dmytroshuba.dailytags.core.simple.Node
import com.dmytroshuba.dailytags.core.simple.Rule
import java.util.regex.Pattern

class LineBreakRule(
    override val pattern: Pattern
): Rule(pattern) {

    override fun parse(): Node = Node(NEW_LINE)

    companion object {
        private const val NEW_LINE = "\n"
    }
}