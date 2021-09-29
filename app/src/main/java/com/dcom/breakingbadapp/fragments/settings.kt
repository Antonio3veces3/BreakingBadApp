package com.dcom.breakingbadapp.fragments

import android.content.Context
import android.content.Intent
import android.media.tv.TvContract
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.dcom.breakingbadapp.R
import com.dcom.breakingbadapp.activities.detailScreen.DetailActivity
import com.dcom.breakingbadapp.models.Character

class settings : Fragment() {

    private var listener: onButtonLogoutListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    interface onButtonLogoutListener {
        fun onClickButtonLogout()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn= view.findViewById<Button>(R.id.btn_logout)
        btn.setOnClickListener{
            listener?.onClickButtonLogout()
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is onButtonLogoutListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener= null
    }
}