package com.example.todoapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChanged: (String) -> Unit,
    onFilterClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        TextField(
            value = query,
            onValueChange = onQueryChanged,
            placeholder = { Text("Rechercher une note") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(42.dp),
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(R.drawable.outline_filter_list_24),
                contentDescription = "Filter Icon"
            )
        }
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(query = "", onQueryChanged = {}, onFilterClick = {})
}