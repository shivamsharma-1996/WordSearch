package com.shivam.wordsearch.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.shivam.wordsearch.feature_dictionary.data.local.Converters
import com.shivam.wordsearch.feature_dictionary.data.local.WordInfoDatabase
import com.shivam.wordsearch.feature_dictionary.data.remote.WordSearchApi
import com.shivam.wordsearch.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.shivam.wordsearch.feature_dictionary.data.util.GsonParser
import com.shivam.wordsearch.feature_dictionary.domain.repository.WordInfoRepository
import com.shivam.wordsearch.feature_dictionary.domain.usecase.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: WordSearchApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideWordSearchApi(): WordSearchApi {
        return Retrofit.Builder()
            .baseUrl(WordSearchApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WordSearchApi::class.java)
    }
}