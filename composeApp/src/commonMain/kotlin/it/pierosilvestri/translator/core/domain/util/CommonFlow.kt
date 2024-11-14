package it.pierosilvestri.translator.core.domain.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

expect class CommonFlow<T>(flow: Flow<T>): Flow<T> 

fun <T> Flow<T>.toCommonFlow() = CommonFlow(this)