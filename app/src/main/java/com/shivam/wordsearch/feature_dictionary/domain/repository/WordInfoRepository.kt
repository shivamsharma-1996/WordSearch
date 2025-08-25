package com.shivam.wordsearch.feature_dictionary.domain.repository

import com.shivam.wordsearch.core.util.Resource
import com.shivam.wordsearch.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}