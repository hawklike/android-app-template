package cz.cvut.fit.steuejan.wanderscope.app.arch

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import cz.cvut.fit.steuejan.wanderscope.app.nav.BottomNavigationScreen
import cz.cvut.fit.steuejan.wanderscope.app.util.runOrLogException

abstract class BaseFragment : Fragment() {

    open val hasBottomNavigation = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleBottomNavigation()
    }

    protected inline fun <T> LiveData<T>.safeObserve(crossinline callback: (T) -> Unit) {
        this.observe(viewLifecycleOwner) {
            callback.invoke(it)
        }
    }

    protected fun navigateTo(@IdRes destinationId: Int, bundle: Bundle? = null) {
        runOrLogException {
            findNavController().navigate(destinationId, bundle)
        }
    }

    protected fun navigateTo(action: NavDirections) {
        runOrLogException {
            findNavController().navigate(action)
        }
    }

    private fun handleBottomNavigation() {
        if (hasBottomNavigation) {
            (activity as? BottomNavigationScreen)?.showBottomNavigation()
        } else {
            (activity as? BottomNavigationScreen)?.hideBottomNavigation()
        }
    }
}