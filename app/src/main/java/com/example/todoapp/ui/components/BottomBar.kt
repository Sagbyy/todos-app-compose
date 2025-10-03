package com.example.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(onHome: () -> Unit = {}, onSearch: () -> Unit = {}, onAdd: () -> Unit = {}) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier) {
            Row(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth(0.75f)
                    .clip(CircleShape)
                    .background(Color(0xffe6b8ff))
                    .height(60.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { onHome },
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",

                        modifier = Modifier
                            .weight(1f)
                    )
                }
                IconButton(
                    onClick = { onAdd },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.LightGray)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Home",
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                IconButton(
                    onClick = { onSearch },
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Home",
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar()
}