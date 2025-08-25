package com.shivam.wordsearch.feature_dictionary.data.remote.dto

import com.shivam.wordsearch.feature_dictionary.data.local.entity.WordInfoEntity

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrl: String,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning()},
            phonetic = phonetic,
            origin = sourceUrl ,
            word = word
        )
    }
}