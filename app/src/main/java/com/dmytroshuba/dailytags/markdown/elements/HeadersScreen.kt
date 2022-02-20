package com.dmytroshuba.dailytags.markdown.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.render

@Composable
fun HeadersScreen(parser: SimpleMarkupParser, rules: List<Rule>) {
    val source = """
        # Heading 1 
        ## Heading 2
        ### Heading 3
        #### Heading 4
        ##### Heading 5
        ###### Heading 6
    """.trimIndent()

    val annotatedString = parser.parse(source, rules).render().toAnnotatedString()

    Text(text = annotatedString)
}