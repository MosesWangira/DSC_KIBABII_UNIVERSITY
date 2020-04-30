package com.example.dscmeetupkibabiiuniversity.ui.onboard.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.dscmeetupkibabiiuniversity.R
import com.example.dscmeetupkibabiiuniversity.databinding.LoginFragmentBinding
import com.example.dscmeetupkibabiiuniversity.ui.onboard.viewmodel.OnBoardViewModel


internal class Login : Fragment(R.layout.login_fragment) {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(OnBoardViewModel::class.java)
    }
    private lateinit var binding: LoginFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginFragmentBinding.bind(view)
        binding.viewmodel = viewModel
    }
}
