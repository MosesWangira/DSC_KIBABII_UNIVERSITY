package com.example.dscmeetupkibabiiuniversity.ui.onboard.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.dscmeetupkibabiiuniversity.R
import com.example.dscmeetupkibabiiuniversity.databinding.RegisterFragmentBinding
import com.example.dscmeetupkibabiiuniversity.ui.onboard.viewmodel.OnBoardViewModel


internal class Register : Fragment(R.layout.register_fragment) {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(OnBoardViewModel::class.java)
    }
    private lateinit var binding: RegisterFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = RegisterFragmentBinding.bind(view)
        binding.viewmodel = viewModel

    }
}
