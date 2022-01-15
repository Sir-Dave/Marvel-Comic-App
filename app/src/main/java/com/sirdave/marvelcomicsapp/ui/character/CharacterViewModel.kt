package com.sirdave.marvelcomicsapp.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirdave.marvelcomicsapp.domain.model.Character
import com.sirdave.marvelcomicsapp.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository,
    @Named("hash") private val hash: String,
    @Named("time_stamp") private val ts: String,
    @Named("apikey") private val apikey: String,
    @Named("limit") private val limit: String) : ViewModel() {

    private val _characters: MutableLiveData<List<Character>> = MutableLiveData()
    val characters: LiveData<List<Character>> get() = _characters

    init {
        getCharacters()
    }

    private fun getCharacters(){
        viewModelScope.launch {
            val result = repository.getAllCharacters(ts, apikey, hash, limit)
            _characters.value = result
        }
    }
}