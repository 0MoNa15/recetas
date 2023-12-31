package com.mona15.infraestructure.dependencyinjection

import com.mona15.infraestructure.country.api.CountryApi
import com.mona15.infraestructure.recipe.detail.api.RecipeDetailApi
import com.mona15.infraestructure.recipe.list.api.RecipeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://demo3790638.mockable.io/"

@Module
@InstallIn(SingletonComponent::class)
class HttpClientModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        httpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideRecipeListApi(retrofit: Retrofit) : RecipeApi = retrofit.create(RecipeApi::class.java)


    @Provides
    fun provideRecipeDetailApi(retrofit: Retrofit) : RecipeDetailApi = retrofit.create(RecipeDetailApi::class.java)

    @Provides
    fun provideCountryApi(retrofit: Retrofit) : CountryApi = retrofit.create(CountryApi::class.java)
}