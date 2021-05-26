package id.ac.unhas.noteapp

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private var noteRepository = NoteRepository(application)
    private var notes: LiveData<List<ContactsContract.CommonDataKinds.Note>>? = noteRepository.getNotes()

    fun insertNote(note: ContactsContract.CommonDataKinds.Note) {
        noteRepository.insert(note)
    }

    fun getNotes(): LiveData<List<ContactsContract.CommonDataKinds.Note>>? {
        return notes
    }

    fun deleteNote(note: ContactsContract.CommonDataKinds.Note) {
        noteRepository.delete(note)
    }

    fun updateNote(note: ContactsContract.CommonDataKinds.Note) {
        noteRepository.update(note)
    }

}