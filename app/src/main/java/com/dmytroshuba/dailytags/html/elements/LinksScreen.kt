package com.dmytroshuba.dailytags.html.elements

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.core.simple.Rule
import com.dmytroshuba.dailytags.core.simple.render
import com.dmytroshuba.dailytags.markdown.styles.Links

@Composable
fun LinksScreen(parser: SimpleMarkupParser, rules: List<Rule>) {
    val uriHandler = LocalUriHandler.current

    val source = """
        Here is a link: <a href="https://regexr.com/">Regex validator</a>
    """.trimIndent()

    val annotatedString = parser
        .parse(source, rules)
        .render()
        .toAnnotatedString()

    ClickableText(
        text = annotatedString,
        onClick = {
            annotatedString
                .getStringAnnotations(Links.Properties.KEY_URL, it, it)
                .firstOrNull()
                ?.let { url -> uriHandler.openUri(url.item) }
        }
    )
}