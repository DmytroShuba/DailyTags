package com.dmytroshuba.dailytags.core.base

import androidx.compose.ui.text.AnnotatedString

/**
 * Node contains information about matching content that was found during parsing.

 * @param source the string that matched a particular pattern.
 * @param children collection of nested nodes if other patterns were matched inside the [source].
 */
open class BaseNode<T: BaseNode<T>>(
    open val source: String,
    private var children: MutableList<T>? = null
) {
    /**
     * Returns children nodes of this node
     */
    open fun getChildren(): List<T>? = children

    /**
     * Adds a child node to the list of children nodes
     */
    open fun addChild(child: T) {
        children = (children ?: ArrayList()).apply {
            add(child)
        }
    }

    /**
     * Adds Node's content to the final string
     */
    open fun render(builder: AnnotatedString.Builder) {
        builder.append(source)
    }
}