package com.dmytroshuba.dailytags.core.simple

import com.dmytroshuba.dailytags.core.base.BaseMarkupParser

/**
 * [SimpleMarkupParser] presets [Node] and [Rule] implementations
 * and uses BaseMarkupParser's algorithm for parsing.
 *
 * @param enableLogging enables logging.
 */

class SimpleMarkupParser(private val enableLogging: Boolean = false) : BaseMarkupParser<Node, Rule>(enableLogging) {

    override fun parse(source: String, rules: List<Rule>): List<Node> {
        return super.parse(source, rules) ?: emptyList()
    }
}