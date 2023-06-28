package io.getmadd.exercise.api
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl("http://api.duckduckgo.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}