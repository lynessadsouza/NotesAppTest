package com.example.us.Database

import android.content.Context
import androidx.room.*
import com.example.notesapp.Models.NoteModelClass

import com.example.roomdb_exercise.NotesDao

@Database(entities = [NoteModelClass::class], version = 1, exportSchema = false )
abstract class NoteDatabase:RoomDatabase()
{
    abstract fun noteDao(): NotesDao

    companion object{
        @Volatile
        private var INSTANCE:NoteDatabase?=null

        fun getDatabase( context: Context): NoteDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null)
            {
                return tempInstance
            }
           synchronized(this){
               val instance=Room.databaseBuilder(
                   context.applicationContext,
                   NoteDatabase::class.java,
                   "notes_database"
               ).build()
               INSTANCE=instance
               return instance
           }

        }
    }
}


