package com.example.todoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapp.ui.screens.HomeScreen
import com.example.todoapp.ui.screens.NoteDetailScreen
import com.example.todoapp.viewmodels.NotesViewModel

@Composable
fun NavGraph(viewModel: NotesViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.HOME) {
        composable(Destinations.HOME) {
            HomeScreen(viewModel, { noteId ->
                navController.navigate(
                    "${Destinations.HOME}/${noteId}"
                )
            }, {}, "My notes Pro")
        }
        composable(
            "${Destinations.DETAIL_NOTE}/{noteId}",
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: -1

            NoteDetailScreen(noteId, viewModel, "My notes Pro", { navController.navigate(
                Destinations.HOME) }, {})
        }
    }
}