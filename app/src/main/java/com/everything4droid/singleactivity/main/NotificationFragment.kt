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
class NotificationFragment : BaseFragment() {

    lateinit var mListener: NotificationInteractionListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is NotificationInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement NotificationFragmentInteractionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        mListener.setToolbarTitle("Notification")
        mListener.setVisibilityBottomNavigation(true)
        mListener.setVisibilityFabButton(true)
        mListener.setBottomNavigation(true, R.id.navigation_notifications)
    }
    companion object {
        fun newInstance(): NotificationFragment {
            return NotificationFragment()
        }
    }

    interface NotificationInteractionListener : MainFragmentInteractionListener,
        FragmentInteractionListener {

    }
}