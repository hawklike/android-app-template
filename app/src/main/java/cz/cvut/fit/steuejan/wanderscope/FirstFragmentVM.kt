package cz.cvut.fit.steuejan.wanderscope

import cz.cvut.fit.steuejan.wanderscope.app.arch.BaseViewModel
import cz.cvut.fit.steuejan.wanderscope.app.nav.NavigationEvent.Destination

class FirstFragmentVM : BaseViewModel() {

    fun doJob() {
        navigateTo(Destination(R.id.action_FirstFragment_to_SecondFragment))
    }

    companion object {
        const val HEADER_ITEM = 0
        const val LISTING_ITEM = 1
        const val AD_ITEM = 2
    }
}