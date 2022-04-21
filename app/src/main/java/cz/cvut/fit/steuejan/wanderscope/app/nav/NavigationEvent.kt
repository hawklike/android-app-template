package cz.cvut.fit.steuejan.wanderscope.app.nav

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavDirections

sealed class NavigationEvent

class ActionNavigation(val action: NavDirections) : NavigationEvent()

class DestinationNavigation(@IdRes val destinationId: Int, val bundle: Bundle? = null) : NavigationEvent()