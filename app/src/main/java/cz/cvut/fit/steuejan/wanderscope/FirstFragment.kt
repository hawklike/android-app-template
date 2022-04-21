package cz.cvut.fit.steuejan.wanderscope

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import cz.cvut.fit.steuejan.wanderscope.app.arch.mwwm.MvvmFragment
import cz.cvut.fit.steuejan.wanderscope.databinding.FragmentFirstBinding


class FirstFragment : MvvmFragment<FragmentFirstBinding, FirstFragmentVM>(
    R.layout.fragment_first,
    FirstFragmentVM::class
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}