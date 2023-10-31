package com.example.store.utils.events

import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlin.coroutines.coroutineContext

/**Created by Arezou-Ghorbani on 28,October,2023,ArezouGhorbaniii@gmail.com**/
object EventBus {
    private val events = MutableSharedFlow<Any>()
    val usableEvent = events.asSharedFlow()

    suspend fun publish(event: Any) {
        events.emit(event)
    }

    suspend inline fun <reified T> subscribe(crossinline onEvent: (T) -> Unit) {
        usableEvent.filterIsInstance<T>().collectLatest {
            coroutineContext.ensureActive()
            onEvent(it)
        }
    }
}