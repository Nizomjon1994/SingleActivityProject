package com.everything4droid.singleactivity.auth

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.everything4droid.singleactivity.R
import com.everything4droid.singleactivity.base.BaseFragment
import com.everything4droid.singleactivity.util.FragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * Created by Khajiev Nizomjon on 12/08/2018.
 */
class RegisterFragment : BaseFragment() {

    lateinit var mListener: RegisterFragmentInteractionListener
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is RegisterFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement RegisterFragmentInteractionListener")
        }
    }

    override fun onStart() {
        super.onStart()
        mListener.setVisibilityFabButton(false)
        mListener.setVisibilityBottomNavigation(false)
        mListener.setToolbarTitle("Register")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_register,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerBtn.setOnClickListener {
            mListener.onSuccessRegister()
        }
    }


    companion object {
        fun newInstance(): RegisterFragment {
            return RegisterFragment()
        }
    }

    interface RegisterFragmentInteractionListener : FragmentInteractionListener {
        fun onSuccessRegister()
    }

}