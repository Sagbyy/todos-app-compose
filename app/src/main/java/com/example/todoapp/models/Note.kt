package com.example.todoapp.models

import java.time.Instant

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val createdAt: Long = Instant.now().epochSecond,
    val colorIndex: Int = 0,
)