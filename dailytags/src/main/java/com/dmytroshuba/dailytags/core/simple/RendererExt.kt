package com.dmytroshuba.dailytags.core.simple

import androidx.compose.ui.text.AnnotatedString

/**
 * [render] iterates through all given nodes to render Nodes content according to
 * their implementation of render function.
 *
 * @param builder AnnotatedString.Builder holds final string after all nodes have been rendered.
 *
 * @return AnnotatedString.Builder
 */
fun <T : Node, PR : Collection<T>> PR.render(
    builder: AnnotatedString.Builder = AnnotatedString.Builder()
): AnnotatedString.Builder {
    forEach { it.render(builder) }
    return builder
}