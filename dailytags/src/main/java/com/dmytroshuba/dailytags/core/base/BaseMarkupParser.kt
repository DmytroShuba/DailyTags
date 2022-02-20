package com.dmytroshuba.dailytags.core.base

import android.util.Log
import com.dmytroshuba.dailytags.core.simple.Node
import com.dmytroshuba.dailytags.core.base.exception.ParseException
import java.util.*

/**
 * BaseMarkupParser is a base implementation of MarkupParser that uses default [Node] and [BaseRule]
 */
open class BaseMarkupParser<N: BaseNode<N>, R: BaseRule<N>>(
    private val enableLogging: Boolean = false
): MarkupParser<N, R> {

    /**
     * The function parses the source string and returns a list of nodes.
     *
     * @param source the content to be parsed.
     * @param rules list of rules that specify how source is parsed.
     *
     * @see Node
     */
    override fun parse(source: String, rules: List<R>): List<N>? {
        if (rules.isEmpty() || source.isEmpty()) {
            return null
        }

        val rootNode = BaseNode<N>(source)
        val spec = Spec(rootNode, 0, source.length)
        val parsesStack = Stack<Spec<N>>()
        parsesStack.push(spec)
        var lastCapture: String?

        while (parsesStack.isNotEmpty()) {
            val current = parsesStack.pop()
            val start = current.start
            val end = current.end
            if (start >= end) {
                break
            }
            val inspectionSegment = source.subSequence(start, end)
            val rule = rules.find { it.match(inspectionSegment) }
                ?: throw ParseException("Matching rule cannot be found")

            val node = rule.parse()
            rootNode.addChild(node)

            val offset = start + rule.matcher.end()
            if (offset != current.end) {
                val newSpec = Spec(node, offset, current.end)
                parsesStack.push(newSpec)
            }

            lastCapture = rule.matcher.group()
            if (enableLogging) {
                Log.d(TAG_MARKUP_PARSER, "Last capture: $lastCapture")
            }
        }

        return rootNode.getChildren()?.toList()
    }

    companion object {
        private const val TAG_MARKUP_PARSER = "MarkupParser"
    }
}