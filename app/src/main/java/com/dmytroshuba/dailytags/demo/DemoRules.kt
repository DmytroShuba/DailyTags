package com.dmytroshuba.dailytags.demo

import androidx.compose.ui.unit.sp
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.toRule
import com.dmytroshuba.dailytags.markdown.MarkdownStyles
import com.dmytroshuba.dailytags.markdown.rules.HtmlRules
import com.dmytroshuba.dailytags.markdown.rules.PATTERN_TEXT
import java.util.regex.Pattern

object DemoRules {

    private val PATTERN_DATE = Pattern.compile("^<date>([\\s\\S]+?)</date>")

    private val PATTERN_HIGHLIGHT_BLUE = Pattern.compile("^<hl-blue>([\\s\\S]+?)</hl-blue>")

    fun toList(): List<Rule> {
        return listOf(
            HtmlRules.PATTERN_HEADER_1.toRule(MarkdownStyles.headers.h1.copy(fontSize = 24.sp)),
            HtmlRules.PATTERN_BOLD.toRule(MarkdownStyles.emphasis.bold),
            HtmlRules.PATTERN_ITALIC.toRule(MarkdownStyles.emphasis.italic),
            PATTERN_DATE.toRule(DemoStyles.date),
            PATTERN_HIGHLIGHT_BLUE.toRule(DemoStyles.highlightBlue),
            ColoredOrderedListRule(HtmlRules.PATTERN_LIST_ITEM_UNORDERED),
            PATTERN_TEXT.toRule()
        )
    }
}