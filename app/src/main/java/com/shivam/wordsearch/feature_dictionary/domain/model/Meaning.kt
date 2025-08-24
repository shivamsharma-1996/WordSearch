package com.shivam.wordsearch.feature_dictionary.domain.model

import com.shivam.wordsearch.feature_dictionary.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition >,
    val partOfSpeech: String,
)
