package com.dmytroshuba.dailytags.markdown.rules

import com.dmytroshuba.dailytags.core.base.annotation.ExperimentalParserApi
import com.dmytroshuba.dailytags.markdown.MarkdownStyles
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.Rule.Companion.applyCustomSettings
import com.dmytroshuba.dailytags.core.simple.toRule
import com.dmytroshuba.dailytags.markdown.custom.*
import com.dmytroshuba.dailytags.markdown.styles.Links

/**
 * MarkdownRules is a collection of markdown rules.
 */
object MarkdownRules {

    // Headers
    val PATTERN_HEADER_1 = """^\s*(#)[ \t](.*) *(?=\n|$)""".toPattern()

    val PATTERN_HEADER_2 = """^\s*(##)[ \t](.*) *(?=\n|$)""".toPattern()

    val PATTERN_HEADER_3 = """^\s*(###)[ \t](.*) *(?=\n|$)""".toPattern()

    val PATTERN_HEADER_4 = """^\s*(####)[ \t](.*) *(?=\n|$)""".toPattern()

    val PATTERN_HEADER_5 = """^\s*(#####)[ \t](.*) *(?=\n|$)""".toPattern()

    val PATTERN_HEADER_6 = """^\s*(######)[ \t](.*) *(?=\n|$)""".toPattern()

    // Emphasis
    val PATTERN_BOLD_1 = """^__${REGEX_PLAIN_TEXT}__""".toPattern()

    val PATTERN_BOLD_2 = """^\*\*$REGEX_PLAIN_TEXT\*\*""".toPattern()

    val PATTERN_ITALIC_1 = """^\*$REGEX_PLAIN_TEXT\*""".toPattern()

    val PATTERN_ITALIC_2 = """^_${REGEX_PLAIN_TEXT}_""".toPattern()

    // Inline
    @ExperimentalParserApi
    val PATTERN_CODE = """^```(?:.{2,})\n([\s\S]*?)```${'$'}""".toPattern()

    val PATTERN_INLINE = "^`${REGEX_PLAIN_TEXT}`".toPattern()

    @ExperimentalParserApi
    val BLOCKQUOTE = """^(([A-Z]+, )?(>{1,10})(.*)$)""".toPattern()

    // Link
    val PATTERN_LINK = """^(?:\[([\w\s]{1,})\])(?:\()(https:\/\/.*)(?:\))""".toPattern()

    // List
    val PATTERN_LIST_ITEM = """^\s*\*[ \t](.*)(?=\n|$)""".toPattern()

    val PATTERN_LIST_ITEM_DASH = """^\s*\-[ \t](.*)(?=\n|$)""".toPattern()

    val PATTERN_LIST_ITEM_ORDERED = """^\s*([0-9]+\.[ \t])([^\S\s]*.*)""".toPattern()

    // Misc
    val PATTERN_LINE_BREAK = """<br[ t]\/>""".toPattern()

    val PATTERN_NEW_LINE = """^\n""".toPattern()

    /**
     * Creates a list markdown rules
     */
    fun toList(): List<Rule> {
        return listOf(
            PATTERN_NEW_LINE.toRule(),
            PATTERN_HEADER_6.toRule(MarkdownStyles.headers.h6),
            PATTERN_HEADER_5.toRule(MarkdownStyles.headers.h5),
            PATTERN_HEADER_4.toRule(MarkdownStyles.headers.h4),
            PATTERN_HEADER_3.toRule(MarkdownStyles.headers.h3),
            PATTERN_HEADER_2.toRule(MarkdownStyles.headers.h2),
            PATTERN_HEADER_1.toRule(MarkdownStyles.headers.h1),
            OrderedListItemRule(PATTERN_LIST_ITEM_ORDERED, MarkdownStyles.lists.ordered),
            UnorderedListRule(PATTERN_LIST_ITEM, MarkdownStyles.lists.unordered),
            UnorderedListRule(PATTERN_LIST_ITEM_DASH, MarkdownStyles.lists.unordered),
            PATTERN_BOLD_1.toRule(MarkdownStyles.emphasis.bold),
            PATTERN_BOLD_2.toRule(MarkdownStyles.emphasis.bold),
            PATTERN_ITALIC_1.toRule(MarkdownStyles.emphasis.italic),
            PATTERN_ITALIC_2.toRule(MarkdownStyles.emphasis.italic),
            PATTERN_INLINE.toRule(MarkdownStyles.code.inline),
            LineBreakRule(PATTERN_LINE_BREAK),
            PATTERN_LINK.toRule(MarkdownStyles.links.link).applyCustomSettings(1, onMatch = Links.onMatch),
            PATTERN_TEXT.toRule()
        )
    }
}