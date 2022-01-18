package com.sirdave.marvelcomicsapp.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirdave.marvelcomicsapp.domain.Character
import com.sirdave.marvelcomicsapp.util.CharacterDtoMapper
import com.sirdave.marvelcomicsapp.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository,
    @Named("hash") private val hash: String,
    @Named("time_stamp") private val ts: String,
    @Named("apikey") private val apikey: String,
    private val mapper: CharacterDtoMapper
) : ViewModel() {

    private val _characterById: MutableLiveData<Character> = MutableLiveData()
    val characterId: LiveData<Character> get() = _characterById

    fun searchCharacterById(id: Int){
        viewModelScope.launch {
            getCharacter(id)
        }
    }

    private suspend fun getCharacter(id: Int){
        val result = repository.getCharacterById(id, ts, apikey, hash)
        _characterById.value = result
    }

    fun addNewFavourite(character: Character) = viewModelScope.launch {
        val favourite = mapper.mapCharacterToFavourite(character)
        repository.addNewFavourite(favourite)
    }

    fun deleteFavourite(character: Character) = viewModelScope.launch {
        val favourite = mapper.mapCharacterToFavourite(character)
        repository.deleteFavourite(favourite)
    }

    fun isFavouriteExists(character: Character): Boolean = runBlocking {
        val isExists = repository.getOneFavourite(character.id!!)
        return@runBlocking isExists != null
    }
}