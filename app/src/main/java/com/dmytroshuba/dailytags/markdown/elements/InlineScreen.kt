package com.dmytroshuba.dailytags.markdown.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.render

@Composable
fun InlineScreen(parser: SimpleMarkupParser, rules: List<Rule>) {
    val annotate: (source: String) -> AnnotatedString = { text ->
        parser.parse(text, rules).render().toAnnotatedString()
    }

    InlineCode(annotate)
}

@Composable
private fun InlineCode(annotate: (source: String) -> AnnotatedString) {
    val source = """
        `inlined code`
    """.trimIndent()

    Text(text = annotate(source))
}