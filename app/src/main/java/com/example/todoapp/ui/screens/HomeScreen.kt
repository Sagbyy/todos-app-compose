package com.example.todoapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.viewmodels.NotesViewModel
import com.example.todoapp.ui.components.NoteCard
import com.example.todoapp.ui.components.TopBar

@Composable
fun HomeScreen(
    viewModel: NotesViewModel,
    onOpenNote: (Int) -> Unit,
    onOpenSettings: () -> Unit,
    folder: String = "My notes"
) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            TopBar(
                "Just do it !",
                showBackButton = false,
                onBackClick = {},
                onSettingsClick = onOpenSettings
            )

            Text(
                text = "${viewModel.notes.size} Notes",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            // SearchBar

            Text(
                text = folder,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            // LazyVerticalGrid --> Afficher les notes
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)

            ) {
                items(viewModel.notes) {
                    NoteCard(it)
                }
            }


            // BottomBar
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(NotesViewModel(), {}, {})
}