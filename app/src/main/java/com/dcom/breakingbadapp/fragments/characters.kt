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
import com.dcom.breakingbadapp.activities.detailScreen.DetailActivity
import com.dcom.breakingbadapp.adapters.CharactersListAdapter
import com.dcom.breakingbadapp.databinding.FragmentCharactersBinding
import com.dcom.breakingbadapp.models.Character
import com.dcom.breakingbadapp.viewModels.CharacterViewModel
import java.lang.ClassCastException

class characters : Fragment() {
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

    public interface CharacterSelectListener{
        fun onCharacterSelected(character: Character)
    }
    private lateinit var characterSelectListener: CharacterSelectListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        characterSelectListener= try {
            context as CharacterSelectListener
        }catch (error: ClassCastException){
            throw ClassCastException("$context must be implemented CharacterSelectedListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val characterViewModel= ViewModelProvider(this).get(CharacterViewModel::class.java)
        val binding= FragmentCharactersBinding.inflate(inflater, container, false)

        characterViewModel.characters.observe(viewLifecycleOwner, Observer<MutableList<Character>>{
            characters->
            val adapter= CharactersListAdapter(characters)

            adapter.onClickItem={
                Log.i("mz","Character: ${it.img}")
                characterSelectListener.onCharacterSelected(it)
            }
            binding.recyclerCharacterList.layoutManager= LinearLayoutManager(requireActivity())
            binding.recyclerCharacterList.adapter= adapter
        })

        return binding.root
    }

}