package com.dcom.breakingbadapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dcom.breakingbadapp.models.Phrase
import com.dcom.breakingbadapp.services.quotesService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhraseViewModel: ViewModel() {

    private var _phrases = MutableLiveData<MutableList<Phrase>>()

    val phrases: LiveData<MutableList<Phrase>>
        get() = _phrases

    init {
        viewModelScope.launch {
            _phrases.value = fetch()
        }
    }

    fun refresh(){
        viewModelScope.launch {
            _phrases.value = fetch()
        }
    }

    private suspend fun fetch() : MutableList<Phrase>{
        return withContext(Dispatchers.IO){
            val phrases: MutableList<Phrase> = quotesService.getQuotes()

            phrases
        }
    }
}