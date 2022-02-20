package com.dmytroshuba.dailytags.html.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.render

@Composable
fun EmphasisScreen(parser: SimpleMarkupParser, rules: List<Rule>) {
    val source = """
        This is plain text. And here is:
        <b>Bold text using b tag</b>
        <strong>Bold text using strong tag</strong>
        <i>Italic text using i tag</i>
        <em>Italic text using em tag</em>
        <i>Nested italic with <b>bold</b> and then italic again</i>(not fully supported yet)
        <mark>Highlight using mark tag</mark>
        <s>Strike through using s tag</s>
        <strike>Strike through using strike tag</strike>
    """.trimIndent()

    val annotatedString = parser
        .parse(source, rules)
        .render()
        .toAnnotatedString()

    Text(text = annotatedString)
}