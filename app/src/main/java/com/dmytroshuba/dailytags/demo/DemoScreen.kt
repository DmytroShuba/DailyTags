package com.dmytroshuba.dailytags.demo

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import com.dmytroshuba.dailytags.core.simple.SimpleMarkupParser
import com.dmytroshuba.dailytags.core.simple.render

@Composable
fun DemoScreen() {
    val parser = SimpleMarkupParser()

    // simply reuse styles from Markdown rules (h1, i, b, li tags) and support custom ones(date, hl-blue)
    val rules = DemoRules.toList()

    val annotate: (source: String) -> AnnotatedString = { source ->
        parser.parse(source, rules).render().toAnnotatedString()
    }

    Article(annotate)
}

@Composable
private fun Article(annotate: (source: String) -> AnnotatedString) {
    val source = """
        <h1>There’s no speed limit</h1>
        <date>2022-02-06</date>

        <hl-blue>If you’re more driven than most people, you can do way more than anyone expects.</hl-blue>

        When the studio owner heard I was going to Berklee, he said, <i>“I graduated from Berklee and taught there. I’ll bet I can teach you two years of theory in only a few lessons. Come by my studio tomorrow for your first lesson.”</i>

        Graduate college in two years? Awesome! I really liked his style. That was <b>Kimo Williams.</b>

        He taught me that:
        <li> the system is designed so anyone can keep up </li>
        <li> You can do way more than anyone expects </li>
        <li> This principle applies to all of life, not just school. </li>

        I showed up at his studio at 8:40 the next morning, super excited, though I waited outside before ringing his bell at 8:59.
    """.trimIndent()

    Text(text = annotate(source))
}
