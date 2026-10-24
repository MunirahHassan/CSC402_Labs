package sa.edu.iau.cshj.studyplanner.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class PlannerUiState(
    val greeting: String = "Hello, Munirah",
    val totalTasks: Int = 7,
    val completedTasks: Int = 0
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onAddTaskClick: () -> Unit,
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
            text = uiState.greeting,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "${uiState.completedTasks} of ${uiState.totalTasks} tasks done",
            style = MaterialTheme.typography.bodyLarge
        )
        Button(onClick = onAddTaskClick) {
            Text("Add New Task")
        }
    }
}

@Preview(showBackground = true, name = "Nothing Done Yet")
@Composable
private fun PlannerHomeScreenNothingDonePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(completedTasks = 0, totalTasks = 7),
            onAddTaskClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Everything Done")
@Composable
private fun PlannerHomeScreenEverythingDonePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(completedTasks = 7, totalTasks = 7),
            onAddTaskClick = {}
        )
    }
}