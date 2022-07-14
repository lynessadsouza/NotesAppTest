package com.example.notesapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable



@Entity(tableName = "notes_table")
data class NoteModelClass(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title : String ?,
    var desription: String
): Serializable {

}