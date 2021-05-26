package id.ac.unhas.noteapp

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Query("Select * from note")
    fun getNotes(): LiveData<List<ContactsContract.CommonDataKinds.Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: ContactsContract.CommonDataKinds.Note)

    @Delete
    suspend fun deleteNote(note: ContactsContract.CommonDataKinds.Note)

    @Update
    suspend fun updateNote(note: ContactsContract.CommonDataKinds.Note)
}