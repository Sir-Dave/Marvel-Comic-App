package com.sirdave.marvelcomicsapp.ui.favourites

import androidx.lifecycle.*
import com.sirdave.marvelcomicsapp.db.entity.Favourite
import com.sirdave.marvelcomicsapp.network.model.CharacterDtoMapper
import com.sirdave.marvelcomicsapp.repository.CharacterRepository
import kotlinx.coroutines.launch

class FavouritesViewModel(
    private val repository: CharacterRepository) : ViewModel() {

    private var _favourites: MutableLiveData<List<Favourite>> = MutableLiveData()
    val favourites: LiveData<List<Favourite>> = _favourites

    init {
        getAllFavourites()
    }

    private fun getAllFavourites(){
        viewModelScope.launch {
            val results = repository.getAllFavourites()
            _favourites.value = results
        }
    }

    fun getOneFavourite(id: Long) = viewModelScope.launch {
        repository.getOneFavourite(id)
    }
}