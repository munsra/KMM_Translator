package it.pierosilvestri.translator.translate.data.remote

import io.ktor.client.HttpClient

/**
 * We EXPECT this class will be implementate in commonMain and iosMain
 */
expect class HttpClientFactory {
    fun create(): HttpClient
}