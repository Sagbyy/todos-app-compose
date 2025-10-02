package com.example.todoapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.models.Note

@Composable
fun NoteCard(
    note: Note
) {
    val backgroundColor = when(note.colorIndex % 4) {
        0 -> Color(0xFFA00EE3)
        1 -> Color(0xFFC261EF)
        2 -> Color(0xFFFF8AF3)
        else -> Color(0xFFE0AAFF)
    }

    Surface(shape = RoundedCornerShape(8.dp), color = backgroundColor) {
        Column(modifier = Modifier.padding(all = 12.dp)) {
            Text("${note.title} #${note.id}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.padding(12.dp))
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Contenue de la note ${note.id}")
                Text("Ajoute du texte ici")
            }
        }
    }
}

@Preview
@Composable
fun NoteCardPreview() {
    NoteCard(Note(1, "Titre de la note", "Ceci est le contenu de la note", colorIndex = 3))
}