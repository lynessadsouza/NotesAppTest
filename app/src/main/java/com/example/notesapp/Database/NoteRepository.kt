package com.example.roomdb.Database

import androidx.lifecycle.LiveData
import com.example.notesapp.Models.NoteModelClass
import com.example.roomdb_exercise.NotesDao

class NoteRepository(private val notesDao: NotesDao) {
    val readAllData: LiveData<List<NoteModelClass>> = notesDao.readAllNotes()


     fun addNote(noteModelClass: NoteModelClass) {
        notesDao.addNote(noteModelClass)
    }

     fun updateNote(noteModelClass: NoteModelClass)
    {
        notesDao.updateNote(noteModelClass)
    }

     fun deleteNote(noteModelClass: NoteModelClass )
    {
        notesDao.deleteNote(noteModelClass)
    }




}