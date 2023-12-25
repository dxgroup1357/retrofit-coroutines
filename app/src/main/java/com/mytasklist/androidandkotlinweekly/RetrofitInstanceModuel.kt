package com.mytasklist.androidandkotlinweekly


//const val BASE_URL = "http://restapi.adequateshop.com/api/"
const val BASE_URL = "https://api.publicapis.org/"

/*
@Module
@InstallIn(SingletonComponent::class)
class RetrofitInstanceModule() {

    @Provides
    @Singleton
    fun theRetrofitInstance() : APIService {

        val client = OkHttpClient().newBuilder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .addInterceptor(Interceptor { chain ->
                val newRequest = chain.request().newBuilder()
                   // .addHeader("Authorization", " Bearer ${}")
                    .build()
                chain.proceed(newRequest)
            }).build()



        val API : APIService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(APIService::class.java)
        }
        return API
    }

*/
