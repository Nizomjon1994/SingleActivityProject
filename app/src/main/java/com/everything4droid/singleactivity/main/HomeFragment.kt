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
class HomeFragment : BaseFragment() {

    lateinit var mListener: HomeFragmentInteractionListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is HomeFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement HomeFragmentInteractionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    interface HomeFragmentInteractionListener : FragmentInteractionListener,MainFragmentInteractionListener {
    }

    override fun onStart() {
        super.onStart()
        mListener.setBottomNavigation(true,R.id.navigation_home)
        mListener.setVisibilityFabButton(true)
        mListener.setVisibilityBottomNavigation(true)
        mListener.setToolbarTitle("Home")
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}