package com.example.todoapp.repositories

import com.example.todoapp.models.Note

class NoteRepository {
    private val notes = mutableListOf<Note>(
        Note(
            1,
            "Hello World!",
            "Lorem Ipsum dolor sit amet, consectetur adipiscing elit...",
            colorIndex = 0
        ),
        Note(
            2,
            "Work Meeting Notes",
            "Discussed progress on project X, deadlines, and...",
            colorIndex = 1
        ),
        Note(
            3,
            "Class Notes",
            "Lecture on Biology: DNA structures and replication...",
            colorIndex = 2
        ),
        Note(
            4,
            "Project Plan",
            "Research, design, implementation, testing, deployements...",
            colorIndex = 1
        ),
    )

    fun addNote(note: Note) = notes.add(note)

    fun getAllNotes(): List<Note> = notes

    fun getById(id: Int): Note? = notes.find { it.id == id }

    fun deleteNote(note: Note) = notes.removeIf { it.id == note.id }

    fun update(updateNote: Note) {
        val index = notes.indexOfFirst { it.id == updateNote.id }
        if (index >= 0) {
            notes[index] = updateNote
        }
    }
}