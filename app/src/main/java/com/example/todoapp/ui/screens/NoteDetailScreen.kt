package com.example.todoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import com.example.todoapp.ui.components.TopBar
import com.example.todoapp.viewmodels.NotesViewModel

@Composable
fun NoteDetailScreen(
    noteId: Int,
    viewModel: NotesViewModel,
    folderName: String = "My notes",
    onBack: () -> Unit,
    onEditClick: () -> Unit
) {
    val note = viewModel.getNoteById(noteId)
    Surface {
        if (note == null) {
            Column {
                Text("Note est introuvable")
                Button(onBack) {
                    Text("Retour")
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                TopBar("", true, onBack, onEditClick)

                Column(modifier = Modifier.padding(12.dp)) {
                    Text("20th February 2024 - 10:00 AM", fontSize = 10.sp, fontWeight = FontWeight.Medium)

                    Spacer(Modifier.height(14.dp))

                    Text("${note.title} #${note.id}", fontSize = 28.sp, fontWeight = FontWeight.Bold)

                    Spacer(Modifier.height(14.dp))

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.shadow(2.dp),
                        color = Color(0xFFF5C6F9)
                    ) {
                        Text(
                            folderName,
                            modifier = Modifier.padding(
                                12.dp
                            ), fontSize = 14.sp, fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(Modifier.height(14.dp))

                    Text(note.content)

                }
            }
        }
    }

}

@Preview
@Composable
fun NoteDetailScreenPreview() {
    NoteDetailScreen(1, NotesViewModel(), onBack = {}, onEditClick = {})
}