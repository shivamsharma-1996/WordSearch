package com.shivam.wordsearch.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shivam.wordsearch.feature_dictionary.domain.model.Meaning
import com.shivam.wordsearch.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String? = null,
    val origin: String? = "",
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            word = word,
            sourceUrl = origin,
            phonetic = phonetic
        )
    }
}