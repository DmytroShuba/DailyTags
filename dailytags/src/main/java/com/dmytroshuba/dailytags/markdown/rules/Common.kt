package com.dmytroshuba.dailytags.markdown.rules

internal const val REGEX_PLAIN_TEXT = "([\\s\\S]+?)"
val PATTERN_TEXT = "^[\\s\\S]+?(?=[^0-9A-Za-z\\s\\u00c0-\\uffff]|\\n| {2,}\\n|\\w+:\\S|$)".toPattern()