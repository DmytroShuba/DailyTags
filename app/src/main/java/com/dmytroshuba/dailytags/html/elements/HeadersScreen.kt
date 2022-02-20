package com.dmytroshuba.dailytags.html.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.render

@Composable
fun HeadersScreen(parser: SimpleMarkupParser, rules: List<Rule>) {
    val source = """
        <h1>Heading 1</h1> 
        <h2>Heading 2</h2>
        <h3>Heading 3</h3>
        <h4>Heading 4</h4>
        <h5>Heading 5</h5>
        <h6>Heading 6</h6>
    """.trimIndent()

    val annotatedString = parser.parse(source, rules).render().toAnnotatedString()

    Text(text = annotatedString)
}