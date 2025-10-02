package com.example.todoapp.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.todoapp.models.Note
import com.example.todoapp.repositories.NoteRepository
import kotlin.random.Random

class NotesViewModel : ViewModel() {
    private val repo = NoteRepository()

    private val _notes = mutableStateListOf<Note>().apply { addAll(repo.getAllNotes()) }
    val notes: List<Note> = _notes

    fun addSampleNote() {
        var id: Int
        do {
            id = Random.Default.nextInt()
        } while (_notes.indexOfFirst { it.id == id } == -1)

        val note = Note(
            id,
            "Sample Note #${id}",
            "Sample Content"
        )

        _notes.add(note)
        repo.addNote(note)
    }

    fun getNoteById(id: Int): Note? = repo.getById(id)

    fun deleteNote(note: Note) {
        val isSuccess: Boolean = repo.deleteNote(note)
        if (!isSuccess) return
        _notes.removeIf { it.id == note.id }
    }

    fun updateNote(note: Note) {
        val index = _notes.indexOfFirst { it.id == note.id }
        if (index == -1) return

        repo.update(note)
        _notes[index] = note
    }
}