package com.parvinder.starwars.ui.screens.matches

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.parvinder.starwars.ui.screens.composables.MatchItem
import com.parvinder.starwars.ui.screens.pointTable.PointTableViewModel

@Composable
fun MatchScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    id: Int,
    viewModel: PointTableViewModel = hiltViewModel()
) {
    val character = viewModel.getCharacter(id) ?: return
    Scaffold(topBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("back", modifier.clickable { navHostController.popBackStack() })

            Text(character.name, textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
        }
    }) {
        Box(modifier = modifier.padding(it)) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Matches")
            LazyColumn {
                items(character.matches.size, key = { i ->
                    val key =
                        character.matches[i].let { x -> "${x.player1.playerId}_${x.player2.playerName}_${x.player2.score}" }
                    key
                }) { idx ->
                    MatchItem(item = character.matches[idx])
                }
            }
        }
    }
}