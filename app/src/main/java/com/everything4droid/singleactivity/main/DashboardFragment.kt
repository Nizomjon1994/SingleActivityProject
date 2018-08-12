package com.everything4droid.singleactivity.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.everything4droid.singleactivity.R
import com.everything4droid.singleactivity.base.BaseFragment
import com.everything4droid.singleactivity.util.FragmentInteractionListener
import com.everything4droid.singleactivity.util.MainFragmentInteractionListener

/**
 * Created by Khajiev Nizomjon on 12/08/2018.
 */
class DashboardFragment : BaseFragment() {


    lateinit var mListener: DashboardFragmentInteractionListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is DashboardFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement DashboardFragmentInteractionListener")

        }
    }

    override fun onStart() {
        super.onStart()
        mListener.setBottomNavigation(true, R.id.navigation_dashboard)
        mListener.setVisibilityFabButton(true)
        mListener.setVisibilityBottomNavigation(true)
        mListener.setToolbarTitle("Dashboard")

    }

    companion object {
        fun newInstance(): DashboardFragment {
            return DashboardFragment()
        }
    }

    interface DashboardFragmentInteractionListener : FragmentInteractionListener,
        MainFragmentInteractionListener {

    }
}