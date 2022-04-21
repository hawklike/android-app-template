package cz.cvut.fit.steuejan.wanderscope.app.arch

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import timber.log.Timber

abstract class BaseFragment : Fragment() {

    protected inline fun <T> LiveData<T>.observe(crossinline callback: (T) -> Unit) {
        this.observe(viewLifecycleOwner) {
            callback.invoke(it)
        }
    }

    protected open fun navigateTo(@IdRes destinationId: Int, bundle: Bundle? = null) {
        try {
            findNavController().navigate(destinationId, bundle)
        } catch (ex: Exception) {
            when (ex) {
                is IllegalStateException -> Timber.e(ex)
                is IllegalArgumentException -> Timber.e(ex)
                else -> throw ex
            }
        }
    }

    protected open fun navigateTo(action: NavDirections) {
        try {
            findNavController().navigate(action)
        } catch (ex: IllegalArgumentException) {
            Timber.e(ex)
        }
    }
}