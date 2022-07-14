package com.example.notesapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.Models.NoteModelClass
import com.example.notesapp.R
import com.example.notesapp.ViewModel.NoteViewModel
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        saveNote.setOnClickListener {
            addNoteToDatabase()
        }
    }


    private fun addNoteToDatabase() {
        val title = noteTitle.text.toString()
        val desc = noteDesc.text.toString()
        val note = NoteModelClass(0, title, desc)
        noteViewModel.addNote(note)
        Toast.makeText(this, "Note Added", Toast.LENGTH_LONG).show()


    }
}