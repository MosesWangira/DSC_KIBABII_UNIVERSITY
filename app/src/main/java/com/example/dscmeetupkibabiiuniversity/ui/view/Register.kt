package com.example.dscmeetupkibabiiuniversity.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dscmeetupkibabiiuniversity.R
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar!!.hide()

        btn_register.setOnClickListener(this)
        have_account.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        return when (v?.id) {
            R.id.btn_register -> {
                registerUser()
            }
            R.id.have_account -> {
                startActivity(Intent(this, Login::class.java))
            }
            else -> return

        }
    }

    private fun registerUser() {
        /*
        * TODO : Add our firebase logic here please use kotlin synthetics
        *
        * */
        startActivity(Intent(this, MainActivity::class.java))
    }
}
