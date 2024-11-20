package com.parvinder.starwars.ui.screens.pointTable

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches
import com.parvinder.starwars.domain.usecase.GetCharactersUseCase
import com.parvinder.starwars.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PointTableViewModel @Inject constructor(private val getCharacterUseCase: GetCharactersUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow(PointTableState())
    val uiState = _uiState.asStateFlow()

    init {
        getCharacterList()
    }

    private fun getCharacterList() {
        viewModelScope.launch {
            getCharacterUseCase.invoke().collectLatest {
                when (it) {
                    is Resource.Success -> {
                        Log.d("PointTableScreen: ",it.data.toString())

                        _uiState.update { x ->
                            x.copy(it.data)
                        }
                    }

                    is Resource.Error -> {
                        Log.d("getCharacterList: ", it.msg)
                    }
                }
            }
        }
    }

     fun getCharacter(id: Int): StarWarCharacterWithMatches? {
        return _uiState.value.list.find { it.id == id }


    }


}