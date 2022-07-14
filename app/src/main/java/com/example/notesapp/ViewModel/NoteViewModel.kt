package com.example.notesapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notesapp.Models.NoteModelClass
import com.example.roomdb.Database.NoteRepository
import com.example.us.Database.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<NoteModelClass>>
    private val repository: NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        readAllData = repository.readAllData
    }

    fun addNote(noteModelClass: NoteModelClass) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(noteModelClass)
        }

    }

    fun updateNote(noteModelClass: NoteModelClass) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(noteModelClass)
        }

    }

    fun deleteNote(noteModelClass: NoteModelClass) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(noteModelClass)
        }
    }

}