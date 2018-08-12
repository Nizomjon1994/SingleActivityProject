package com.everything4droid.singleactivity.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.everything4droid.singleactivity.R

/**
 * Created by Khajiev Nizomjon on 12/08/2018.
 */
open class NavigationManager(private val mFragmentManager: FragmentManager, private val container: Int) {

    init {
        mFragmentManager.addOnBackStackChangedListener {
            navigationListener?.invoke()
        }
    }

    val isRootFragmentVisible: Boolean
        get() = mFragmentManager.backStackEntryCount <= 1

    /**
     * Listener interface for navigation events.
     */
    var navigationListener:(()->Unit)?=null


    /**
     * Displays the next fragment
     *
     * @param fragment
     */
    fun open(fragment: Fragment) {
        mFragmentManager.beginTransaction()
        openFragment(fragment,true)
    }

    private fun openFragment(fragment: Fragment,addToBackStack:Boolean) {
        val fragTransaction=mFragmentManager.beginTransaction()
        fragTransaction.replace(container, fragment)
        fragTransaction.setCustomAnimations(
            R.anim.slide_in_left,
            R.anim.slide_out_right,
            R.anim.slide_in_right,
            R.anim.slide_out_left)
        if (addToBackStack)
            fragTransaction.addToBackStack(fragment.toString())
        fragTransaction.commit()
    }

    /**
     * pops every fragment and starts the given fragment as a new one.
     *
     * @param fragment
     */
    fun openAsRoot(fragment: Fragment) {
        popEveryFragment()
        openFragment(fragment,false)
    }

    /**
     * Pops all the queued fragments
     */
    private fun popEveryFragment() {
        // Clear all back stack.
        val backStackCount = mFragmentManager.backStackEntryCount
        for (i in 0 until backStackCount) {
            // Get the back stack fragment id.
            val backStackId = mFragmentManager.getBackStackEntryAt(i).id
            mFragmentManager.popBackStack(backStackId, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }


    fun navigateBack():Boolean {
        return if (mFragmentManager.backStackEntryCount==0) {
            false
        } else {
            mFragmentManager.popBackStackImmediate()
            true
        }
    }


}
