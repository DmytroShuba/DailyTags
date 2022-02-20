package com.dmytroshuba.dailytags.markdown.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.render

@Composable
fun EmphasisScreen(parser: SimpleMarkupParser, rules: List<Rule>) {
    val source = """
        This is plain text. And here is:
        __Bold text using double underscore__
        **Bold text using double star**
        _Italic text using single underscore_
        *Italic text using single star*
    """.trimIndent()
    val annotatedString = parser
        .parse(source, rules)
        .render()
        .toAnnotatedString()

    Text(text = annotatedString)
}