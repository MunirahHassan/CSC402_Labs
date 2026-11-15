package sa.edu.iau.cshj.lab07.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.lab07.ui.components.StarRating

data class CourseRatingUiState(val code: String, val stars: Float = 0f)

@Composable
fun CourseRatingScreen(
    uiState: CourseRatingUiState,
    onStarsChange: (Float) -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Rate ${uiState.code}")
        StarRating(stars = uiState.stars, onStarsChange = onStarsChange)
        Text("You gave ${uiState.stars} stars")
        Button(onClick = onResetClick) { Text("Reset") }
    }
}

@Composable
fun CourseRatingRoute(code: String, modifier: Modifier = Modifier) {
    var stars by rememberSaveable { mutableStateOf(0f) }
    CourseRatingScreen(
        uiState = CourseRatingUiState(code, stars),
        onStarsChange = { newStars -> stars = newStars },
        onResetClick = { stars = 0f },
        modifier = modifier
    )
}