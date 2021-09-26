package com.dcom.breakingbadapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dcom.breakingbadapp.R
import com.dcom.breakingbadapp.databinding.CharacterListItemBinding
import com.dcom.breakingbadapp.models.Character

class CharactersListAdapter(private val characterList: List<Character>) : RecyclerView.Adapter<CharactersListAdapter.ViewHolder>(){

    lateinit var onClickItem: (Character) -> Unit

    inner class ViewHolder(private val binding: CharacterListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(characters: Character){
            Glide
                .with(binding.root)
                .load("https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.profileImage)

            binding.root.setOnClickListener{
                if(::onClickItem.isInitialized)
                    onClickItem(characters)
                else
                    Log.i("mz", "onCharacterClick is not initialized")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterListItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.count()
    }
}
