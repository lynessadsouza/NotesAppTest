package com.example.roomdb_exercise

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesapp.Models.NoteModelClass


@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addNote( note: NoteModelClass)
    @Update
     fun updateNote(note:NoteModelClass)
    @Delete
     fun deleteNote(note:NoteModelClass)
    @Query("SELECT * FROM notes_table ")
    fun readAllNotes():LiveData<List<NoteModelClass>>




}