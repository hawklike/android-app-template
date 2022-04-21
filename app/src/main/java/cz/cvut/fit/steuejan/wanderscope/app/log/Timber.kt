package cz.cvut.fit.steuejan.wanderscope.app.log

import android.util.Log.DEBUG
import android.util.Log.VERBOSE
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import cz.cvut.fit.steuejan.wanderscope.BuildConfig
import timber.log.Timber

fun initTimber() {
    if (BuildConfig.DEBUG) {
        Timber.plant(Timber.DebugTree())
    } else {
        Timber.plant(CrashReportingTree())
    }
}

private class CrashReportingTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority in listOf(VERBOSE, DEBUG)) {
            return
        }

        t?.let {
            Firebase.crashlytics.log(message)
            Firebase.crashlytics.recordException(it)
        }
    }
}