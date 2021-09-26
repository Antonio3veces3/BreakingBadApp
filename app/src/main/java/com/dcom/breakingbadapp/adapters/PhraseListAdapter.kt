package com.dcom.breakingbadapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dcom.breakingbadapp.databinding.PhrasesItemBinding
import com.dcom.breakingbadapp.models.Phrase

class PhraseListAdapter(private val phrase: List<Phrase>) : RecyclerView.Adapter<PhraseListAdapter.ViewHolder>() {

   lateinit var onClickItemPhrase: (Phrase) -> Unit

    inner class ViewHolder(private val binding: PhrasesItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(phrase: Phrase){

            binding.nameAuthor.text = phrase.author
            binding.phrase.text = phrase.quote

            binding.root.setOnClickListener{
                if(::onClickItemPhrase.isInitialized)
                    onClickItemPhrase(phrase)
                else
                    Log.i("mz", "onPhraseClick is not initialized")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PhrasesItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhraseListAdapter.ViewHolder, position: Int) {
        holder.bind(phrase[position])
    }

    override fun getItemCount(): Int {
       return phrase.count()
    }


}