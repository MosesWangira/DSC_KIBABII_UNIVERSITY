package com.example.dscmeetupkibabiiuniversity.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dscmeetupkibabiiuniversity.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()

        btn_login.setOnClickListener(this)
        login_register.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        return when (v?.id){
            R.id.btn_login -> {
                login()
            }
            R.id.login_register -> {
                startActivity(Intent(this,Register::class.java))
            }
            else -> return
        }

    }

    private fun login() {

        /*
        * TODO : Add our firebase logic here please use kotlin synthetics
        *
        * */
        startActivity(Intent(this,MainActivity::class.java))
    }


}
