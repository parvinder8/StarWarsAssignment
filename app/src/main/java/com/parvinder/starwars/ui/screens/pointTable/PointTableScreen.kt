package com.parvinder.starwars.ui.screens.pointTable

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.parvinder.starwars.ui.navigation.Routes
import com.parvinder.starwars.ui.screens.composables.StarWarCharacterItem


@Composable
fun PointTableScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: PointTableViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val characterList = state.list
    Log.d("PointTableScreen: ",characterList.toString())
    Scaffold(topBar = {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 20.dp), contentAlignment = Alignment.Center) {
            Text("Star Wars Blast Tournament")
        }
    }) {
        Box(modifier = modifier.padding(it)) {
            Text(text = "Points Table")
            LazyColumn {
                items(characterList.size, key = {
                    val key = characterList[it].let { x -> "${x.id}_${x.name}" }
                    key
                }) { idx ->
                    StarWarCharacterItem(item = characterList[idx]) { c ->
                        navHostController.navigate("${Routes.MATCH_LIST}/${c.id}")
                    }
                }
            }

        }
    }
}