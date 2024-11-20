package com.parvinder.starwars.ui.screens.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.parvinder.starwars.data.models.StarWarCharacterMatch
import com.parvinder.starwars.data.models.StarWarMatchResultEnum

@Composable
fun MatchItem(modifier: Modifier = Modifier, item: StarWarCharacterMatch) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .background(
                color =
                    when (item.result) {
                        StarWarMatchResultEnum.WIN -> {
                           Color(0x00ff00)
                        }

                        StarWarMatchResultEnum.LOSS -> {
                            Color(0xFF0000)

                        }

                        StarWarMatchResultEnum.DRAW -> {
                            Color(0xFFFFFF)
                        }
                    }

            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = item.player1.playerName, Modifier.weight(1f))
        Text(text = "${item.player1.score} - ${item.player2.score}", Modifier.weight(1f))
        Text(text = item.player2.playerName, Modifier.weight(1f))

    }


}