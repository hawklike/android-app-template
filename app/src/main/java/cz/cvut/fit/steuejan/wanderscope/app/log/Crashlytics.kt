package cz.cvut.fit.steuejan.wanderscope.app.log

import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import cz.cvut.fit.steuejan.wanderscope.BuildConfig

fun initFirebaseCrashlytics() {
    if (BuildConfig.DEBUG) {
        Firebase.crashlytics.setCrashlyticsCollectionEnabled(false)
    }

    Firebase.crashlytics.setCustomKey(FIREBASE_FLAVOR_KEY, BuildConfig.FLAVOR)
}

const val FIREBASE_FLAVOR_KEY = "env"