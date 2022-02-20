package com.dmytroshuba.dailytags.html.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.render

@Composable
fun ListsScreen(parser: SimpleMarkupParser, rules: List<Rule>) {
    val annotate: (source: String) -> AnnotatedString = { text ->
        parser.parse(text, rules).render().toAnnotatedString()
    }

    Column {
        UnorderedLists(annotate)
        OrderedLists(annotate)
    }
}

@Composable
private fun UnorderedLists(annotate: (source: String) -> AnnotatedString) {
    val source = """
        Starting with li tag:
        <li>First</li>
        <li>Second</li>
        <li>Third</li>
    """.trimIndent()

    Text(text = annotate(source))
}

@Composable
private fun OrderedLists(annotate: (source: String) -> AnnotatedString) {
    val source = """
        Starting with ol:
        <ol> Ordered item 1 </ol>
        <ol> Ordered item 2 </ol>
        <ol> Ordered item 3 </ol>
    """.trimIndent()

    Text(text = annotate(source))
}