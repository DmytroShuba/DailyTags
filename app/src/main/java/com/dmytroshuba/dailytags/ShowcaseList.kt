package com.dmytroshuba.dailytags

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowcaseList(
    items: List<String>,
    navigate: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items) { item -> ShowcaseItem(item, navigate) }
    }
}

@Composable
fun ShowcaseItem(section: String, navigate: (String) -> Unit) {
    Column(
        modifier = Modifier.clickable { navigate(section) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = section,
                fontSize = 16.sp,
                modifier = Modifier
            )

            Icon(
                painter = rememberVectorPainter(Icons.Filled.KeyboardArrowRight),
                contentDescription = "arrow forward"
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}