package com.programmersbox.fullmultiplatformcomposetest3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.runtime.rememberCoroutineScope
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
internal data class DadJoke(
    val id: String?,
    val joke: String?
)

private val json = Json {
    isLenient = true
    prettyPrint = true
    ignoreUnknownKeys = true
    coerceInputValues = true
}

private val client by lazy {
    HttpClient {

    }
}

internal suspend fun getDadJoke() = json.decodeFromString<DadJoke>(
    client.get("https://icanhazdadjoke.com/") { header("Accept", "application/json") }.bodyAsText()
)

@Composable
internal fun <T> getApiJoke(key: Any, request: suspend () -> T?): State<Result<T>> {
    val scope = rememberCoroutineScope()
    // Creates a State<T> with Result.Loading as initial value
    // If either `url` or `imageRepository` changes, the running producer
    // will cancel and will be re-launched with the new inputs.
    return produceState<Result<T>>(Result.Loading, key) {
        //We start by making value Loading so that it will show the loading screen everytime
        value = Result.Loading

        // In a coroutine, can make suspend calls
        val joke = withTimeout(5000) { withContext(scope.coroutineContext) { request() } }

        // Update State with either an Error or Success result.
        // This will trigger a recomposition where this State is read
        value = joke?.let { Result.Success(joke) } ?: Result.Error
    }
}

internal sealed class Result<out R> {
    class Success<out T>(val value: T) : Result<T>()
    object Error : Result<Nothing>()
    object Loading : Result<Nothing>()
}