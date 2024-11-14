package it.pierosilvestri.translator.translate.data.translate

import kotlinx.serialization.Serializable


/**
 * This class has the translation result
 */
@Serializable
data class TranslatedDto(
    val translatedText: String
)
