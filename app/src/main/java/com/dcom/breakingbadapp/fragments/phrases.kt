package com.dcom.breakingbadapp.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcom.breakingbadapp.adapters.PhraseListAdapter
import com.dcom.breakingbadapp.databinding.FragmentPhrasesBinding
import com.dcom.breakingbadapp.models.Phrase
import com.dcom.breakingbadapp.viewModels.PhraseViewModel
import java.lang.ClassCastException

class phrases : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    public interface PhraseSelectListener{
        fun onPhraseSelected(phrase: Phrase)
    }

    private lateinit var phraseSelectListener: phrases.PhraseSelectListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        phraseSelectListener = try {
            context as PhraseSelectListener
        }catch (error: ClassCastException){
            throw ClassCastException("$context must be implemented PhraseSelectListener")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val phraseViewModel = ViewModelProvider(this).get(PhraseViewModel::class.java)
        val binding = FragmentPhrasesBinding.inflate(inflater, container, false)

        phraseViewModel.phrases.observe(viewLifecycleOwner, Observer<MutableList<Phrase>>{
            phrases ->

            val adapter = PhraseListAdapter(phrases)

            adapter.onClickItemPhrase = {
                phraseSelectListener.onPhraseSelected(it)
            }

            binding.recyclerPhrase.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerPhrase.adapter = adapter

        })

        return binding.root
    }
}