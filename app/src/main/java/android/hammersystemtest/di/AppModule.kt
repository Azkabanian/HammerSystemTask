package android.hammersystemtest.di

import android.hammersystemtest.data.api.HammerSystemTestApi
import android.hammersystemtest.data.repository.HammerSystemTestRepositoryImpl
import android.hammersystemtest.domain.HammerSystemTestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): HammerSystemTestApi {

        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()


        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("www.themealdb.com/api/json/v1/1/")
            .client(okHttpClient)
            .build()
            .create(HammerSystemTestApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHammerSystemRepository(api: HammerSystemTestApi) : HammerSystemTestRepository {
        return HammerSystemTestRepositoryImpl(api)
    }
}