package com.shivam.wordsearch.feature_dictionary.data.remote.dto

import com.shivam.wordsearch.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phoneticDtos: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings.map { it.toMeaning()},
            phonetic = phonetic,
            sourceUrls = sourceUrls,
            word = word
        )
    }
}