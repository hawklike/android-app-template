package cz.cvut.fit.steuejan.wanderscope.app.util

import timber.log.Timber

inline fun <T> runOrLogException(call: () -> T) {
    runCatching(call).getOrElse { Timber.e(it) }
}

inline fun <T> runOrNull(call: () -> T): T? {
    return runCatching(call).getOrNull()
}