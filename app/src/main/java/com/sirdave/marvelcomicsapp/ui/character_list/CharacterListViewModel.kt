package com.sirdave.marvelcomicsapp.ui.character_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirdave.marvelcomicsapp.domain.Character
import com.sirdave.marvelcomicsapp.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val repository: CharacterRepository,
    @Named("hash") private val hash: String,
    @Named("time_stamp") private val ts: String,
    @Named("apikey") private val apikey: String) : ViewModel() {

    private val _characters: MutableLiveData<List<Character>> = MutableLiveData()
    val characters: LiveData<List<Character>> get() = _characters

    init {
        getCharacters()
    }

    private fun getCharacters(){
        viewModelScope.launch {
            try {
                val result = repository.getAllCharacters(ts, apikey, hash)
                _characters.value = result
            }
            catch (ex: Exception){
                ex.printStackTrace()
            }
        }
    }
}