package it.pierosilvestri.translator.translate.domain.translate

import it.pierosilvestri.translator.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}