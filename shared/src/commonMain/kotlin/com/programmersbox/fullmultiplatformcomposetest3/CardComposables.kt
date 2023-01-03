package com.programmersbox.fullmultiplatformcomposetest3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.*
import kotlin.math.max

@Composable
internal fun rememberDeck(vararg key: Any) = remember(key) { Deck.defaultDeck() }

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun PlayingCard(
    card: Card,
    modifier: Modifier = Modifier,
    tonalElevation: Dp = 4.dp,
    shape: Shape = RoundedCornerShape(7.dp),
    enabled: Boolean = true,
    color: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(color),
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {}
) = Surface(
    onClick = onClick,
    shape = shape,
    elevation = tonalElevation,
    enabled = enabled,
    contentColor = contentColor,
    border = border,
    interactionSource = interactionSource,
    modifier = modifier.size(100.dp, 150.dp),
) {
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = card.toSymbolString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            textAlign = TextAlign.Start
        )
        FlowRow(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            lastLineMainAxisAlignment = FlowMainAxisAlignment.Center
        ) { repeat(card.value) { Text(text = card.suit.unicodeSymbol, textAlign = TextAlign.Center) } }
        Text(
            text = card.toSymbolString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            textAlign = TextAlign.End
        )
    }
}

/*@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmptyCard(
    modifier: Modifier = Modifier,
    tonalElevation: Dp = 4.dp,
    shape: Shape = RoundedCornerShape(7.dp),
    enabled: Boolean = true,
    color: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(color),
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {}
) = Surface(
    onClick = onClick,
    shape = shape,
    elevation = tonalElevation,
    enabled = enabled,
    contentColor = contentColor,
    border = border,
    interactionSource = interactionSource,
    modifier = modifier.size(100.dp, 150.dp),
) {}*/

/*@Composable
fun CardPreview() {
    MaterialTheme {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            PlayingCard(card = Card.RandomCard)
            PlayingCard(card = Card[13])
            EmptyCard()
        }
    }
}*/
