package com.dcom.breakingbadapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dcom.breakingbadapp.R
import com.dcom.breakingbadapp.adapters.PhraseListAdapter
import com.dcom.breakingbadapp.databinding.FragmentPhrasesBinding
import com.dcom.breakingbadapp.models.Phrase
import java.lang.ClassCastException

class settings : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    public interface LogOutSelectListener{
        fun onLogOutSelected(phrase: Phrase)
    }

    private lateinit var logOutSelectListener: settings.LogOutSelectListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logOutSelectListener = try {
            context as settings.LogOutSelectListener
        }catch (error: ClassCastException){
            throw ClassCastException("$context must be implemented PhraseSelectListener")
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

}