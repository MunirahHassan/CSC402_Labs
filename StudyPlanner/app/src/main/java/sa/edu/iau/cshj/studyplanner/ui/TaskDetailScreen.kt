package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme
import android.content.Intent
import androidx.compose.ui.platform.LocalContext
data class TaskDetailUiState(
    val title: String = ""
)

@Composable
fun TaskDetailScreen(
    uiState: TaskDetailUiState,
    onShareClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = uiState.title,
            style = MaterialTheme.typography.headlineMedium
        )
        Button(onClick = onShareClick) {
            Text("Share Task")
        }
        OutlinedButton(onClick = onBackClick) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true, name = "Math Task Preview")
@Composable
private fun TaskDetailScreenMathPreview() {
    StudyPlannerTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState(title = "Math assignment"),
            onShareClick = {},
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Lab Task Preview")
@Composable
private fun TaskDetailScreenLabPreview() {
    StudyPlannerTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState(title = "Lab 5 report"),
            onShareClick = {},
            onBackClick = {}
        )
    }
}
@Composable
fun TaskDetailRoute(title: String, onBackClick: () -> Unit) {
    val context = LocalContext.current

    TaskDetailScreen(
        uiState = TaskDetailUiState(title = title),
        onShareClick = {
            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT, "Today I'm studying: $title")
                type = "text/plain"
            }
            context.startActivity(Intent.createChooser(sendIntent, "Share via"))
        },
        onBackClick = onBackClick
    )
}