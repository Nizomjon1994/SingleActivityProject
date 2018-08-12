package com.everything4droid.singleactivity.util

import com.everything4droid.singleactivity.base.BaseFragment

/**
 * Created by Khajiev Nizomjon on 12/08/2018.
 */
interface FragmentInteractionListener {

    fun setToolbarTitle(title: String)

    fun setCurrentFragment(fragment : BaseFragment)

    fun setVisibilityBottomNavigation(show:Boolean)

    fun setVisibilityFabButton(show: Boolean)


}