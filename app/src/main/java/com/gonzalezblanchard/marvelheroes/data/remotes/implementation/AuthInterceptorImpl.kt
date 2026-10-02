package com.gonzalezblanchard.marvelheroes.data.remotes.implementation

import com.gonzalezblanchard.marvelheroes.BuildConfig
import com.gonzalezblanchard.marvelheroes.utils.PreferencesManager
import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest
import javax.inject.Inject

class AuthInterceptorImpl @Inject constructor(
    private val sharedPreferences: PreferencesManager,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        try{
            val original = chain.request()
            val originalHttpUrl = original.url
            val timestamp = System.currentTimeMillis().toString()
            val hash = md5(timestamp + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_PUBLIC_KEY)

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("apikey", BuildConfig.MARVEL_PUBLIC_KEY)
                .addQueryParameter("ts", timestamp)
                .addQueryParameter("hash", hash)
                .build()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            return chain.proceed(request)
        }catch (ex:Exception){
            return chain.proceed(chain.request().newBuilder().build())
        }
    }

    private fun md5(value: String): String {
        val digest = MessageDigest.getInstance("MD5").digest(value.toByteArray(Charsets.UTF_8))
        return digest.joinToString(separator = "") { byte -> "%02x".format(byte) }
    }

}
