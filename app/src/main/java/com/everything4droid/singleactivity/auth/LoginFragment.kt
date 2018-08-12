package com.everything4droid.singleactivity.auth

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.everything4droid.singleactivity.R
import com.everything4droid.singleactivity.base.BaseFragment
import com.everything4droid.singleactivity.util.FragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created by Khajiev Nizomjon on 12/08/2018.
 */
class LoginFragment : BaseFragment() {

    lateinit var listener: LoginFragmentInteractionListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBtn.setOnClickListener {
            listener.onSuccessLogin(emailT.text.toString(), passwordT.text.toString())
        }

        registerBtn.setOnClickListener {
            listener.onRequestRegister()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is LoginFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement LoginFragmentInteractionListener")
        }
    }

    interface LoginFragmentInteractionListener : FragmentInteractionListener {

        fun onSuccessLogin(email: String, password: String)

        fun onRequestRegister()
    }

    override fun onStart() {
        super.onStart()
        listener.setVisibilityFabButton(false)
        listener.setVisibilityBottomNavigation(false)
        listener.setToolbarTitle("Login")
    }

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }
}