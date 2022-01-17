package com.sirdave.marvelcomicsapp.ui.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sirdave.marvelcomicsapp.db.entity.Favourite
import com.sirdave.marvelcomicsapp.repository.CharacterRepository
import kotlinx.coroutines.launch

class FavouritesViewModel(
    private val repository: CharacterRepository) : ViewModel() {

    private var _favourites = repository.getAllFavourites().asLiveData()
    val favourites = _favourites


    fun getOneWord(id: Long) = viewModelScope.launch {
        repository.getOneFavourite(id)
    }

    fun insert(favourite: Favourite) = viewModelScope.launch {
        repository.addNewFavourite(favourite)
    }

    fun delete(favourite: Favourite) = viewModelScope.launch {
        repository.deleteFavourite(favourite)
    }


}