@file:JvmName("ActivityHelper")

package com.jamesnyakush.core.util

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
     * Base object for Movie Module Activities.
     */
    object MovieModule {

        object Movie : AddressableActivity {
            override val className = "com.androidstudy.movies.ui.views.activities.MovieActivity"
        }

    }



}