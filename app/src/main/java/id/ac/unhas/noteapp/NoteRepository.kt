package id.ac.unhas.noteapp

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NoteRepository(application: Application) {

    private val noteDao: NoteDao?
    private var notes: LiveData<List<ContactsContract.CommonDataKinds.Note>>? = null

    init {
        val db = AppDatabase.getInstance(application.applicationContext)
        noteDao = db?.noteDao()
        notes = noteDao?.getNotes()
    }

    fun getNotes(): LiveData<List<ContactsContract.CommonDataKinds.Note>>? {
        return notes
    }

    fun insert(note: ContactsContract.CommonDataKinds.Note) = runBlocking {
        this.launch(Dispatchers.IO) {
            noteDao?.insertNote(note)
        }
    }

    fun delete(note: ContactsContract.CommonDataKinds.Note) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                noteDao?.deleteNote(note)
            }
        }
    }

    fun update(note: ContactsContract.CommonDataKinds.Note) = runBlocking {
        this.launch(Dispatchers.IO) {
            noteDao?.updateNote(note)
        }
    }

}