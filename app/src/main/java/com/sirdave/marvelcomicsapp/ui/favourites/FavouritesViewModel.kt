package com.sirdave.marvelcomicsapp.ui.favourites

import androidx.lifecycle.*
import com.sirdave.marvelcomicsapp.db.entity.Favourite
import com.sirdave.marvelcomicsapp.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val repository: CharacterRepository) : ViewModel() {

    var favourites: LiveData<List<Favourite>> = MutableLiveData()

    init {
        getAllFavourites()
    }

    private fun getAllFavourites() {
        viewModelScope.launch {
            val results = repository.getAllFavourites()
            favourites = results.asLiveData()
        }
    }
}