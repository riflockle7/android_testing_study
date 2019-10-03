package riflocike.co.kr.androidtesttdd.network.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private var instance: NetworkInterface? = null
private var retrofit: Retrofit? = null

const val baseURL = "http://52.79.87.95:3001"

private val requestHeader: OkHttpClient
    get() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(interceptor).build()
    }

fun getInstance(): NetworkInterface? {
    if (instance == null) {
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .client(requestHeader)
            .addConverterFactory(GsonConverterFactory.create())
            .build().apply {
                instance = create(NetworkInterface::class.java)
            }
    }

    return instance
}