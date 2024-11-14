package it.pierosilvestri.translator.translate.data.translate

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import it.pierosilvestri.translator.NetworkConstants
import it.pierosilvestri.translator.core.domain.language.Language
import it.pierosilvestri.translator.translate.domain.translate.TranslateClient
import it.pierosilvestri.translator.translate.domain.translate.TranslateError
import it.pierosilvestri.translator.translate.domain.translate.TranslateException
import okio.IOException

class KtorTranslateClient(
    private val httpClient: HttpClient
): TranslateClient {
    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        val result = try {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/translate")
                contentType(ContentType.Application.Json)
                setBody(
                    TranslateDto(
                        textToTranslate = fromText,
                        sourceLanguageCode = fromLanguage.langCode,
                        targetLanguageCode = toLanguage.langCode
                    )
                )
            }
        } catch (e: IOException){
            throw TranslateException(TranslateError.SERVICE_UNAVAILABLE)
        }

        when(result.status.value){
            in 200..2999 -> Unit
            500 -> throw TranslateException(TranslateError.SERVER_ERROR)
            in 400 ..499 -> throw TranslateException(TranslateError.CLIENT_ERROR)
            else -> throw TranslateException(TranslateError.UNKNOWN_ERROR)
        }

        return try {
            result.body<TranslatedDto>().translatedText
        } catch (e: Exception){
            throw TranslateException(TranslateError.SERVER_ERROR)
        }
    }
}