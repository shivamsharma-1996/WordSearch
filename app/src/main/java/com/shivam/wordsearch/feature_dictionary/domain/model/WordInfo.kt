package com.shivam.wordsearch.feature_dictionary.domain.model

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String? = null,
    val sourceUrl: String? = "",
    val word: String
)
