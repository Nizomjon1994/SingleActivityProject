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
class ProfileFragment : BaseFragment(){

    lateinit var mListener: ProfileFragment.ProfileFragmentInteractionListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ProfileFragment.ProfileFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement ProfileFragmentInteractionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        mListener.setToolbarTitle("Notification")
        mListener.setVisibilityBottomNavigation(true)
        mListener.setVisibilityFabButton(true)
        mListener.setBottomNavigation(true, R.id.navigation_profile)
    }
    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }


    interface ProfileFragmentInteractionListener : FragmentInteractionListener,MainFragmentInteractionListener {

    }
}