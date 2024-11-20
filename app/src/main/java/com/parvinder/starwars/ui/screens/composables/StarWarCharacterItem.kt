package com.parvinder.starwars.ui.screens.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches


@Composable
fun StarWarCharacterItem(
    modifier: Modifier = Modifier,
    item: StarWarCharacterWithMatches,
    onItemClick: (StarWarCharacterWithMatches) -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp).clickable { onItemClick(item) }
    ) {
        AsyncImage(
            model = item.icon, contentDescription = item.name, modifier = Modifier.size(80.dp)
        )
        Text(
            text = item.name,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(horizontal = 12.dp)
        )
        Text(
            text = item.points.toString(),
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }

}