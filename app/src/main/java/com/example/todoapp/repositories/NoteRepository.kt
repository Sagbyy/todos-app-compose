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
        Note(
            5,
            "Grocery List",
            "Milk, Eggs, Bread, Butter, Chicken, Vegetables...",
            colorIndex = 3
        ),
        Note(
            6,
            "Travel Itinerary",
            "Flight at 10 AM, hotel check-in at 2 PM, sightseeing...",
            colorIndex = 0
        ),
        Note(
            7,
            "Book Recommendations",
            "1. 'The Great Gatsby' by F. Scott Fitzgerald\n2. '1984' by George Orwell...",
            colorIndex = 2
        ),
        Note(
            8,
            "Fitness Goals",
            "Run 3 times a week, strength training on Mondays and Thursdays...",
            colorIndex = 3
        ),
        Note(
            9,
            "Recipe Ideas",
            "Pasta with homemade tomato sauce, grilled chicken salad...",
            colorIndex = 0
        ),
        Note(
            10,
            "Meeting Agenda",
            "1. Project updates\n2. Budget review\n3. Upcoming deadlines...",
            colorIndex = 1
        ),
        Note(
            11,
            "Birthday Gift Ideas",
            "1. Personalized mug\n2. Book by favorite author\n3. Gift card...",
            colorIndex = 2
        ),
        Note(
            12,
            "Home Improvement Tasks",
            "Paint the living room, fix the leaky faucet, mow the lawn...",
            colorIndex = 3
        ),
        Note(
            13,
            "Learning Goals",
            "Learn Kotlin basics, practice Compose, build a sample app...",
            colorIndex = 0
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