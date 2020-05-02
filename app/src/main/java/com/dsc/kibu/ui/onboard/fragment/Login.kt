package com.dsc.kibu.ui.onboard.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dsc.kibu.R
import com.dsc.kibu.core.Status
import com.dsc.kibu.core.toast
import com.dsc.kibu.databinding.LoginFragmentBinding
import com.dsc.kibu.ui.home.MainActivity
import com.dsc.kibu.ui.onboard.viewmodel.OnBoardViewModel
import com.roger.catloadinglibrary.CatLoadingView
import kotlinx.android.synthetic.main.login_fragment.*


internal class Login : Fragment(R.layout.login_fragment) {

    private lateinit var binding: LoginFragmentBinding
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(OnBoardViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginFragmentBinding.bind(view)
        binding.viewmodel = viewModel

        observeLoginResult()
    }

    private fun observeLoginResult() {
        viewModel.loginResult.observe(viewLifecycleOwner, Observer { result->
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
