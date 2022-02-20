package com.dmytroshuba.dailytags.core.base

/**
 * Parsing specification.
 *
 * @param node the root node that holds current segment.
 * @param start the index where a parsing span starts.
 * @param end the index where a parsing span ends.
 */
data class Spec<N: BaseNode<N>>(
    val node: BaseNode<N>,
    val start: Int = 0,
    val end: Int = 0
)