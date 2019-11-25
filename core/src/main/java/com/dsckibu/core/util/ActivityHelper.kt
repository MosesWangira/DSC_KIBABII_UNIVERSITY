@file:JvmName("ActivityHelper")

package com.dsckibu.core.util

import android.content.Intent

/**
 * Helpers to start activities in a modularized world.
 */

private const val PACKAGE_NAME = "com.jamesnyakus"


/**
 * Create an Intent with [Intent.ACTION_VIEW] to an [AddressableActivity].
 */
fun intentTo(addressableActivity: AddressableActivity): Intent {
    return Intent(Intent.ACTION_VIEW).setClassName(
        PACKAGE_NAME,
        addressableActivity.className
    )
}

/**
 * An [android.app.Activity] that can be addressed by an intent.
 */
interface AddressableActivity {
    val className: String
}

/**
 * All addressable activities.
 *
 * Can contain intent extra names or functions associated with the activity creation.
 */

object Activities {

    /**
     |------------------------------------------------
     | Base object for Android Module Activities.
     |------------------------------------------------
     */
    object AndroidModule {

        object Android : AddressableActivity {
            override val className = "com.dsckibu.android.Android"
        }

    }

    /**
     |------------------------------------------------
     | Base object for web Module Activities.
     |------------------------------------------------
     */
    object WebModule {

        object Web : AddressableActivity {
            override val className = "com.androidstudy.movies.ui.views.activities.MovieActivity"
        }

    }

    /**
     |------------------------------------------------
     | Base object for ML Module Activities.
     |------------------------------------------------
     */
    object MlModule {

        object ML : AddressableActivity {
            override val className = "com.dsckibu.ml.Ml"
        }

    }

    /**
     |------------------------------------------------
     | Base object for Hacking Module Activities.
     |------------------------------------------------
     */
    object HackingModule {

        object Hacking : AddressableActivity {
            override val className = "com.dsckibu.hacking.Hacking"
        }

    }



}