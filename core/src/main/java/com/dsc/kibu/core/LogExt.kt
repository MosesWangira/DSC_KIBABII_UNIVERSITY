package com.dsc.kibu.core

import android.util.Log

/** Logs Info */
fun String?.logInfo(tag: String = "MatchCardsLog") {
    if (BuildConfig.DEBUG) {
        Log.i(tag, this.toString())
    }
}

/** Logs Error */
fun String?.logError(tag: String = "MatchCardsLog") {
    if (BuildConfig.DEBUG) {
        Log.e(tag, this.toString())
    }
}

/** Logs Debug */
fun String?.logDebug(tag: String = "MatchCardsLog") {
    if (BuildConfig.DEBUG) {
        Log.d(tag, this.toString())
    }
}

/** Logs Wtf */
fun String?.logWtf(tag: String = "MatchCardsLog") {
    if (BuildConfig.DEBUG) {
        Log.wtf(tag, this.toString())
    }
}