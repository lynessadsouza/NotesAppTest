package com.example.notesapp.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.ListAdapter
import com.example.notesapp.R
import com.example.notesapp.ViewModel.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        val adapter = ListAdapter(this)
        //   val recyclerview= recyclerView
        notesRec.adapter = adapter
        notesRec.layoutManager = LinearLayoutManager(this)


        noteViewModel.readAllData.observe(this, Observer {note->
            adapter.setData(note)
        })

        addNoteBtn.setOnClickListener {
            val intent = Intent(applicationContext, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }


}