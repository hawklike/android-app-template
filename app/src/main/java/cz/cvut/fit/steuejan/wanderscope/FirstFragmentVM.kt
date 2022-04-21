package cz.cvut.fit.steuejan.wanderscope

import cz.cvut.fit.steuejan.wanderscope.app.arch.BaseViewModel
import cz.cvut.fit.steuejan.wanderscope.app.nav.DestinationNavigation

class FirstFragmentVM : BaseViewModel() {

    fun doJob() {
        navigateTo(DestinationNavigation(R.id.action_FirstFragment_to_SecondFragment))
    }
}