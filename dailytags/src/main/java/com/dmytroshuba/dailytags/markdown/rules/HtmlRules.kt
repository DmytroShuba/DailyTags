package com.dmytroshuba.dailytags.markdown.rules

import com.dmytroshuba.dailytags.markdown.MarkdownStyles
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.Rule.Companion.applyCustomSettings
import com.dmytroshuba.dailytags.core.simple.toRule
import com.dmytroshuba.dailytags.markdown.custom.HtmlOrderedListItemRule
import com.dmytroshuba.dailytags.markdown.custom.UnorderedListRule
import com.dmytroshuba.dailytags.markdown.styles.Links

/**
 * Markdown supports basic html tags along with native markdown syntax.
 * HtmlRules is a collection of rules needed to support basic html syntax
 */
object HtmlRules {

    // Header
    val PATTERN_HEADER_1 = """^<h1>$REGEX_PLAIN_TEXT</h1>""".toPattern()

    val PATTERN_HEADER_2 = """^<h2>$REGEX_PLAIN_TEXT</h2>""".toPattern()

    val PATTERN_HEADER_3 = """^<h3>$REGEX_PLAIN_TEXT</h3>""".toPattern()

    val PATTERN_HEADER_4 = """^<h4>$REGEX_PLAIN_TEXT</h4>""".toPattern()

    val PATTERN_HEADER_5 = """^<h5>$REGEX_PLAIN_TEXT</h5>""".toPattern()

    val PATTERN_HEADER_6 = """^<h6>$REGEX_PLAIN_TEXT</h6>""".toPattern()

    // Emphasis
    val PATTERN_BOLD = """^<b>$REGEX_PLAIN_TEXT</b>""".toPattern()

    val PATTERN_BOLD_2 = """^<strong>$REGEX_PLAIN_TEXT</strong>""".toPattern()

    val PATTERN_ITALIC = """^<i>$REGEX_PLAIN_TEXT</i>""".toPattern()

    val PATTERN_ITALIC_2 = """^<em>$REGEX_PLAIN_TEXT</em>""".toPattern()

    val PATTERN_STRIKETHROUGH = """^<s>$REGEX_PLAIN_TEXT</s>""".toPattern()

    val PATTERN_STRIKETHROUGH_2 = """^<strike>$REGEX_PLAIN_TEXT</strike>""".toPattern()

    val PATTERN_HIGHLIGHT = """^<mark>$REGEX_PLAIN_TEXT</mark>""".toPattern()

    // Link
    val PATTERN_LINK = """^<a href=(?:["'])(.*?)(?:["'])>(.*)(<\/a>)""".toPattern()

    // List
    val PATTERN_LIST_ITEM_UNORDERED = """^<li>$REGEX_PLAIN_TEXT</li>""".toPattern()

    val PATTERN_LIST_ITEM_ORDERED = """^[\r\n]<ol>([\s\S]+?)<\/ol>""".toPattern()

    fun toList(): List<Rule> {
        return listOf(
            PATTERN_HEADER_1.toRule(MarkdownStyles.headers.h1),
            PATTERN_HEADER_2.toRule(MarkdownStyles.headers.h2),
            PATTERN_HEADER_3.toRule(MarkdownStyles.headers.h3),
            PATTERN_HEADER_4.toRule(MarkdownStyles.headers.h4),
            PATTERN_HEADER_5.toRule(MarkdownStyles.headers.h5),
            PATTERN_HEADER_6.toRule(MarkdownStyles.headers.h6),
            PATTERN_BOLD.toRule(MarkdownStyles.emphasis.bold),
            PATTERN_BOLD_2.toRule(MarkdownStyles.emphasis.bold),
            PATTERN_ITALIC.toRule(MarkdownStyles.emphasis.italic),
            PATTERN_ITALIC_2.toRule(MarkdownStyles.emphasis.italic),
            PATTERN_STRIKETHROUGH.toRule(MarkdownStyles.emphasis.strikeThrough),
            PATTERN_STRIKETHROUGH_2.toRule(MarkdownStyles.emphasis.strikeThrough),
            PATTERN_HIGHLIGHT.toRule(MarkdownStyles.emphasis.highlight),
            HtmlOrderedListItemRule(PATTERN_LIST_ITEM_ORDERED, MarkdownStyles.lists.ordered),
            UnorderedListRule(PATTERN_LIST_ITEM_UNORDERED, MarkdownStyles.lists.unordered),
            PATTERN_LINK.toRule(MarkdownStyles.links.link).applyCustomSettings(2, onMatch = Links.onMatchHtml),
            PATTERN_TEXT.toRule()
        )
    }
}