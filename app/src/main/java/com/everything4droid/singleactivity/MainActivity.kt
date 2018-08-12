package com.everything4droid.singleactivity

import android.os.Build.VERSION_CODES.P
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import android.widget.Toast
import com.everything4droid.singleactivity.auth.LoginFragment
import com.everything4droid.singleactivity.auth.RegisterFragment
import com.everything4droid.singleactivity.base.BaseFragment
import com.everything4droid.singleactivity.main.DashboardFragment
import com.everything4droid.singleactivity.main.HomeFragment
import com.everything4droid.singleactivity.main.NotificationFragment
import com.everything4droid.singleactivity.main.ProfileFragment
import com.everything4droid.singleactivity.util.HasNavigationManager
import com.everything4droid.singleactivity.util.NavigationManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HasNavigationManager,
    LoginFragment.LoginFragmentInteractionListener,
    RegisterFragment.RegisterFragmentInteractionListener,
    HomeFragment.HomeFragmentInteractionListener,
    DashboardFragment.DashboardFragmentInteractionListener,
    ProfileFragment.ProfileFragmentInteractionListener,
    NotificationFragment.NotificationInteractionListener{


    lateinit var mNavigationManager: NavigationManager
    var mCurrentFragment: BaseFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        mNavigationManager = NavigationManager(supportFragmentManager, R.id.container)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            mNavigationManager.openAsRoot(LoginFragment.newInstance())
        }
    }

    override fun onBackPressed() {
        if (mCurrentFragment == null || !mCurrentFragment!!.onBackPressed())
            super.onBackPressed()
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    if (supportFragmentManager.backStackEntryCount == 0) {
                        mNavigationManager.open(HomeFragment.newInstance())
                    } else {
                        supportFragmentManager.popBackStack()
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                mNavigationManager.open(DashboardFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                mNavigationManager.open(NotificationFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                mNavigationManager.open(ProfileFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    override fun setToolbarTitle(title: String) {
        this.title = title
    }

    override fun setVisibilityBottomNavigation(show: Boolean) {
        if (show) {
            navigation.visibility = View.VISIBLE
        } else {
            navigation.visibility = View.GONE
        }
    }

    override fun setVisibilityFabButton(show: Boolean) {
        if (show) {
            fab.visibility = View.VISIBLE
        } else {
            fab.visibility = View.GONE
        }
    }

    override fun setCurrentFragment(fragment: BaseFragment) {
        mCurrentFragment = fragment
    }

    override fun provideNavigationManager(): NavigationManager = mNavigationManager


    /*
      Request Register
    */

    override fun onRequestRegister() {
        mNavigationManager.open(RegisterFragment.newInstance())
    }

    /*
     Login Success
    */

    override fun onSuccessLogin(email: String, password: String) {
        mNavigationManager.openAsRoot(HomeFragment.newInstance())
    }

    /*
     Register Success
    */

    override fun onSuccessRegister() {
        mNavigationManager.openAsRoot(LoginFragment.newInstance())
    }

    /*
        Set BottomNavigation
    */

    override fun setBottomNavigation(show: Boolean, menuId: Int) {
        if (show) {
            navigation.visibility = View.VISIBLE

            when (menuId) {
                R.id.navigation_home -> navigation.menu.getItem(0).isChecked = true
                R.id.navigation_dashboard -> navigation.menu.getItem(1).isChecked = true
                R.id.navigation_notifications -> navigation.menu.getItem(2).isChecked = true
                R.id.navigation_profile -> navigation.menu.getItem(3).isChecked = true
            }

        } else
            navigation.visibility = View.GONE
    }


}
