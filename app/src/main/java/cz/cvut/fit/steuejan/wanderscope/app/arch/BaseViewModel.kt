package cz.cvut.fit.steuejan.wanderscope.app.arch

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import cz.cvut.fit.steuejan.wanderscope.app.event.SingleLiveEvent
import cz.cvut.fit.steuejan.wanderscope.app.nav.NavigationEvent

abstract class BaseViewModel(
    protected open val state: SavedStateHandle? = null
) : ViewModel(), LifecycleObserver {

    val navigateEvent = SingleLiveEvent<NavigationEvent>()

    fun navigateTo(event: NavigationEvent) {
        navigateEvent.value = event
    }

    fun navigateToOnBackground(event: NavigationEvent) {
        navigateEvent.postValue(event)
    }

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