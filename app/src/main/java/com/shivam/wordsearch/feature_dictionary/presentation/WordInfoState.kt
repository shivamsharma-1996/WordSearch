package com.shivam.wordsearch.feature_dictionary.presentation

import com.shivam.wordsearch.feature_dictionary.domain.model.WordInfo

data class WordInfoState (
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)

