package cz.cvut.fit.steuejan.wanderscope

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import cz.cvut.fit.steuejan.wanderscope.app.arch.mwwm.MvvmFragment
import cz.cvut.fit.steuejan.wanderscope.databinding.FragmentSecondBinding

class SecondFragment : MvvmFragment<FragmentSecondBinding, SecondFragmentVM>(
    R.layout.fragment_second,
    SecondFragmentVM::class
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}