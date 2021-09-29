package com.dcom.breakingbadapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dcom.breakingbadapp.databinding.FragmentPhrasesBinding
import com.dcom.breakingbadapp.models.Phrase
import com.dcom.breakingbadapp.viewModels.PhraseViewModel

class phrases : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val phrasesViewModel = ViewModelProvider(this).get(PhraseViewModel::class.java)
        val binding = FragmentPhrasesBinding.inflate(inflater, container, false)

        phrasesViewModel.phrases.observe(viewLifecycleOwner, Observer<MutableList<Phrase>> {
            phrase ->

            binding.nameAuthor.text = phrase[0].author
            binding.phrase.text = "\"${phrase[0].quote}\""
        })

        binding.root.setOnClickListener(){
            phrasesViewModel.refresh()
        }

        return binding.root
    }
}