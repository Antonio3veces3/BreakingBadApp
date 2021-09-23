package com.dcom.breakingbadapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcom.breakingbadapp.adapters.CharactersListAdapter
import com.dcom.breakingbadapp.databinding.FragmentCharactersBinding
import com.dcom.breakingbadapp.models.Character
import com.dcom.breakingbadapp.viewModels.CharacterViewModel

class CharacterListFragment : Fragment() {

    public interface CharacterSelectListener{
        fun onCharacterSelected(characters: Character)
    }

    private lateinit var characterSelectListener: CharacterSelectListener
    override fun onAttach(context: Context) {
        super.onAttach(context)

        characterSelectListener = try {
            context as CharacterSelectListener
        }catch (error: ClassCastException){
            throw ClassCastException("$context must implement CharacterSelectListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        val binding = FragmentCharactersBinding.inflate(inflater, container, false)

        characterViewModel.characters.observe(viewLifecycleOwner, Observer<MutableList<Character>> {
            characters ->
            val adapter = CharactersListAdapter(characters)

            adapter.onClickItem = {
                Log.i("mz", "Movie ${it.name}")
                characterSelectListener.onCharacterSelected(it)
            }

            binding.recyclerCharactersList.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerCharactersList.adapter = adapter

        })

        return binding.root
    }
}
