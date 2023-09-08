package minori.eden.sion.mybook.net

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Sion
 * @date 2023/9/5 14:04
 * @description
 * @version 1.0.0
 **/
@Module
@InstallIn(SingletonComponent::class)
object NetModule {


    @Provides
    fun provideOkhttpClient(): OkHttpClient
    = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor())
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit
    = Retrofit.Builder()
        .baseUrl(AppUrl.JUHE_HOST)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun getAppService(retrofit: Retrofit):AppService
    = retrofit.create(AppService::class.java)
}