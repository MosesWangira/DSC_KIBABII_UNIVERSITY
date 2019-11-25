package com.example.dscmeetupkibabiiuniversity.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsckibu.core.util.*
import com.example.dscmeetupkibabiiuniversity.R
import com.example.dscmeetupkibabiiuniversity.ui.adapter.DynamicModuleRecyclerViewAdapter
import com.example.dscmeetupkibabiiuniversity.ui.model.DynamicModule
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var splitInstallManager: SplitInstallManager

    private val AndroidModule by lazy { getString(R.string.title_android) }
    private val WebModule by lazy { getString(R.string.title_web) }
    private val MLModule by lazy { getString(R.string.title_web) }
    private val HackModule by lazy { getString(R.string.title_hacking) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splitInstallManager = SplitInstallManagerFactory.create(this)
        setup()
    }

    private fun setup() {
        val layoutManager = CustomGridLayoutManager(this, 2)
        layoutManager.setScrollEnabled(false)
        recyclerViewModules.layoutManager = layoutManager

        val adapter =
            DynamicModuleRecyclerViewAdapter(
                prepareDynamicModules(),
                this
            ) { position ->
                val modules = prepareDynamicModules()[position]
                when (modules.dynamicModuleTitle) {
                    //
                    Constants.MAIN_DASHBOARD_CARD_ANDROID -> {
                        if (splitInstallManager.installedModules.contains(AndroidModule)) {
                            startActivity(intentTo(Activities.AndroidModule.Android))
                        } else {
                            toast("Android Module is not installed")
                        }
                    }

                    Constants.MAIN_DASHBOARD_CARD_WEB -> {
                        if (splitInstallManager.installedModules.contains(WebModule)) {
                            startActivity(intentTo(Activities.WebModule.Web))
                        } else {
                            toast("Web Module is not installed")
                        }
                    }

                    Constants.MAIN_DASHBOARD_CARD_ML-> {
                        if (splitInstallManager.installedModules.contains(MLModule)) {
                            startActivity(intentTo(Activities.MlModule.ML))
                        } else {
                            toast("Machine Learning Module is not installed")
                        }
                    }

                    Constants.MAIN_DASHBOARD_CARD_HACKING -> {
                        if (splitInstallManager.installedModules.contains(HackModule)) {
                            startActivity(intentTo(Activities.HackingModule.Hacking))
                        } else {
                            toast("Ethical Hacking Module is not installed")
                        }
                    }



                }
            }
        recyclerViewModules.adapter = adapter

    }

    private fun prepareDynamicModules(): List<DynamicModule> {
        val models = ArrayList<DynamicModule>()
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_ANDROID,
                R.drawable.ic_android
            )
        )
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_WEB,
                R.drawable.ic_weeb
            )
        )
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_ML,
                R.drawable.ic_machine_learning
            )
        )
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_HACKING,
                R.drawable.ic_spyware
            )
        )

        return models
    }
}
