package cz.cvut.fit.steuejan.wanderscope.app.arch

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseViewModel(
    protected val state: SavedStateHandle? = null
) : ViewModel(), LifecycleObserver {

    fun <T> setStateData(paramName: String, data: T) {
        state?.set(paramName, data)
    }

    fun <T> getStateData(paramName: String): T? {
        return state?.get<T>(paramName)
    }

    fun <T> getStateLiveData(paramName: String): LiveData<T>? {
        return state?.getLiveData(paramName)
    }
}