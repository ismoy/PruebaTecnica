package com.ismoyb.pruebatecnica.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismoyb.pruebatecnica.domain.model.Item
import com.ismoyb.pruebatecnica.domain.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val repository: BooksRepository):ViewModel() {
    private val _books = MutableLiveData<List<Item>>()
    val books: LiveData<List<Item>> = _books

    fun searchBooks(query:String){
        viewModelScope.launch {
            val response = repository.searchBooks(query)
            if (response.isSuccessful){
                _books.postValue(response.body()?.items)
            }else{
                Log.e("ErrorAlConsultarLaApi","${response.errorBody()}")
            }
        }
    }
}