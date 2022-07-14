package com.example.notesapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Models.NoteModelClass
import com.example.notesapp.View.UpdateNoteActivity
import kotlinx.android.synthetic.main.noteitem.view.*


class ListAdapter(private val context: Context) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var noteList = emptyList<NoteModelClass>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.noteitem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = noteList[position]
        holder.itemView.noteTitle.text = currentItem.title
        holder.itemView.desc.text = currentItem.desription
        holder.itemView.rowLayout.setOnClickListener {
            val intent = Intent(context, UpdateNoteActivity::class.java)
            intent.putExtra("note", noteList[position]) //where user is an instance of User object
            context.startActivity(intent)
        }

    }

    fun setData(note: List<NoteModelClass>) {
        this.noteList = note
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}