package com.dmytroshuba.dailytags.markdown.elements

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
        StarredUnorderedLists(annotate)
        OrderedLists(annotate)
    }
}

@Composable
private fun UnorderedLists(annotate: (source: String) -> AnnotatedString) {
    val source = """
        Dashes:
        - First
        - Second
        - Third
    """.trimIndent()

    Text(text = annotate(source))
}

@Composable
private fun StarredUnorderedLists(annotate: (source: String) -> AnnotatedString) {
    val source = """
        Stars:
        * First
        * Second
        * Third
    """.trimIndent()

    Text(text = annotate(source))
}

@Composable
private fun OrderedLists(annotate: (source: String) -> AnnotatedString) {
    val source = """
        Numbers:
        0. Ordered item 1
        0. Ordered item 2
        0. Ordered item 3
        
        And this is plain text which also contain numbers inside.
        For example, 1. This is the first one 2. This is second.
        And this section should not be reformatted
    """.trimIndent()

    Text(text = annotate(source))
}