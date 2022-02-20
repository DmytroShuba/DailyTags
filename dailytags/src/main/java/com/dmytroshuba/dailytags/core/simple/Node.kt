package com.dmytroshuba.dailytags.core.simple

import androidx.compose.ui.text.AnnotatedString
import com.dmytroshuba.dailytags.core.base.BaseNode

/**
 * Node contains information about matching content that was found during parsing.

 * @param source the string that matched a particular pattern.
 * @param children collection of nested nodes if other patterns were matched inside the [source].
 * @param decoration content appearance specification.
 */
open class Node(
    override val source: String,
    open val decoration: Decoration? = null,
    private var children: MutableList<Node>? = null
) : BaseNode<Node>(source, children) {

    override fun getChildren(): List<Node>? {
        return super.getChildren()
    }

    override fun addChild(child: Node) {
        super.addChild(child)
    }

    /**
     * Adds Node's content to the final string
     * and also applies [decoration] to the content span.
     */
    override fun render(builder: AnnotatedString.Builder) {
        val start = builder.length
        val end = builder.length + source.length
        builder.append(source)
        decoration?.run {
            spanStyle?.let { style ->
                builder.addStyle(style, start, end)
            }
            paragraphStyle?.let { style ->
                builder.addStyle(style, start, end)
            }
            properties?.forEach { entry ->
                builder.addStringAnnotation(entry.key, entry.value, start, end)
            }
        }
    }
}