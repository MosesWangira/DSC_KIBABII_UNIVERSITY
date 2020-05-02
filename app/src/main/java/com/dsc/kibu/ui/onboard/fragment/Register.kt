package com.dsc.kibu.ui.onboard.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dsc.kibu.R
import com.dsc.kibu.core.Status
import com.dsc.kibu.core.toast
import com.dsc.kibu.databinding.RegisterFragmentBinding
import com.dsc.kibu.ui.home.MainActivity
import com.dsc.kibu.ui.onboard.viewmodel.OnBoardViewModel
import com.roger.catloadinglibrary.CatLoadingView


internal class Register : Fragment(R.layout.register_fragment) {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(OnBoardViewModel::class.java)
    }
    private lateinit var binding: RegisterFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = RegisterFragmentBinding.bind(view)
        binding.viewmodel = viewModel

        observeSignUpResult()

    }

    private fun observeSignUpResult() {
        viewModel.signUpResult.observe(viewLifecycleOwner, Observer { result ->
            if (result.status == Status.LOADING) {
                CatLoadingView().show(
                    childFragmentManager,
                    ""
                )
            }
            when (result.status) {
                Status.SUCCESS -> {
                    Intent(context, MainActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                    activity?.finish()
                }
                Status.ERROR -> {
                    if (result.exception != null) {
                        context?.toast(result!!.exception!!.message.toString())
                    } else {
                        context?.toast("Error has Occured")
                    }
                }
                Status.LOADING -> {
                }

            }
        })
    }
}
