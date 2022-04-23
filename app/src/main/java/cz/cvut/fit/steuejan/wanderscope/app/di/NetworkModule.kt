package cz.cvut.fit.steuejan.wanderscope.app.di

import com.squareup.moshi.Moshi
import cz.cvut.fit.steuejan.wanderscope.BuildConfig
import cz.cvut.fit.steuejan.wanderscope.app.serialization.Serializer
import cz.cvut.fit.steuejan.wanderscope.app.session.SessionManagerImpl
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    singleOf(::SessionManagerImpl)
    singleOf(::provideMoshiConverterFactory)
    singleOf(::provideRetrofitBuilder)
    singleOf(::provideOkHttpClientBuilder)
}

private fun provideRetrofitBuilder(converterFactory: retrofit2.Converter.Factory): Retrofit.Builder {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(converterFactory)
}

fun provideMoshiConverterFactory(serializer: Serializer<Moshi>): retrofit2.Converter.Factory {
    return MoshiConverterFactory.create(serializer.getSerializer())
}

fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
}