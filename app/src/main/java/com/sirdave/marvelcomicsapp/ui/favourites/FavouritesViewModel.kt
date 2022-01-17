package com.sirdave.marvelcomicsapp.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirdave.marvelcomicsapp.db.entity.Favourite
import com.sirdave.marvelcomicsapp.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val repository: CharacterRepository) : ViewModel() {

    private var _favourites: MutableLiveData<List<Favourite>> = MutableLiveData()
    val favourites: LiveData<List<Favourite>> = _favourites

    init {
        getAllFavourites()
    }

    private fun getAllFavourites() {
        viewModelScope.launch {
            val results = repository.getAllFavourites()
            _favourites.value = results
        }
    }
}