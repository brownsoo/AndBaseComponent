package com.hansoolabs.and.utils

import android.util.Log
import com.hansoolabs.and.BuildConfig

object HLog {

    private val logLevel = LogLevel.VERBOSE

    private enum class LogLevel {
        NONE,
        ERROR,
        WARNING,
        INFO,
        DEBUG,
        VERBOSE
    }

    @JvmStatic
    fun e(TAG: String, className: String, e: Throwable?) {
        e(TAG, className, Log.getStackTraceString(e))
    }

    @JvmStatic
    fun e(TAG: String, className: String, msg: String? = null) {
        if (LogLevel.ERROR.ordinal <= logLevel.ordinal) {
            val thr = Thread.currentThread().name
            val text = "[$thr] $className ${msg ?: ""}"
            Log.e(TAG, text)
        }
    }

    @JvmStatic
    fun w(TAG: String, className: String, vararg args: Any?) {
        if (BuildConfig.DEBUG && LogLevel.WARNING.ordinal <= logLevel.ordinal) {
            val thr = Thread.currentThread().name
            val msg = args.joinToString()
            val text = "[$thr] $className $msg"
            Log.w(TAG, text)
        }
    }

    @JvmStatic
    fun i(TAG: String, className: String, msg: Any? = null) {
        val thr = Thread.currentThread().name
        val text = "[$thr] $className $msg"
        Log.i(TAG, text)
    }

    @JvmStatic
    fun i(TAG: String, className: String, vararg args: Any?) {
        val thr = Thread.currentThread().name
        val msg = args.joinToString()
        val text = "[$thr] $className $msg"
        Log.i(TAG, text)
    }

    @JvmStatic
    fun d(TAG: String, className: String, msg: Any? = null) {
        if (BuildConfig.DEBUG && LogLevel.DEBUG.ordinal <= logLevel.ordinal) {
            val the = Thread.currentThread().name
            val text = "[$the] $className ${msg?.toString() ?: ""}"
            Log.d(TAG, text)
        }
    }

    @JvmStatic
    fun d(TAG: String, className: String, vararg args: Any?) {
        if (BuildConfig.DEBUG && LogLevel.DEBUG.ordinal <= logLevel.ordinal) {
            val the = Thread.currentThread().name
            val msg = args.joinToString()
            val text = "[$the] $className $msg"
            Log.d(TAG, text)
        }
    }

    @JvmStatic
    fun v(TAG: String, className: String, msg: Any? = null) {
        if (BuildConfig.DEBUG && LogLevel.VERBOSE.ordinal <= logLevel.ordinal) {
            val thr = Thread.currentThread().name
            val text = "[$thr] $className ${msg?.toString() ?: ""}"
            Log.v(TAG, text)
        }
    }

    @JvmStatic
    fun v(TAG: String, className: String, vararg args: Any?) {
        if (BuildConfig.DEBUG && LogLevel.VERBOSE.ordinal <= logLevel.ordinal) {
            val thr = Thread.currentThread().name
            val msg = args.joinToString()
            val text = "[$thr] $className $msg"
            Log.v(TAG, text)
        }
    }
}



fun Any.hlogee(TAG: String, className: String, b: () -> Throwable?) {
    if (BuildConfig.DEBUG) {
        HLog.e(TAG, className, b.invoke())
    }
}

fun Any.hloges(TAG: String, className: String, b: ()-> String?) {
    if (BuildConfig.DEBUG) {
        HLog.e(TAG, className, b.invoke())
    }
}
fun Any.hlogi(TAG: String, className: String, b: ()-> String?) {
    if (BuildConfig.DEBUG) {
        HLog.i(TAG, className, b.invoke())
    }
}

fun Any.hlogd(TAG: String, className: String, b: ()-> String?) {
    if (BuildConfig.DEBUG) {
        HLog.d(TAG, className, b.invoke())
    }
}

fun Any.hlogv(TAG: String, className: String, b: ()-> String?) {
    if (BuildConfig.DEBUG) {
        HLog.v(TAG, className, b.invoke())
    }
}

fun Any.hlogw(TAG: String, className: String, b: ()-> String?) {
    if (BuildConfig.DEBUG) {
        HLog.w(TAG, className, b.invoke())
    }
}