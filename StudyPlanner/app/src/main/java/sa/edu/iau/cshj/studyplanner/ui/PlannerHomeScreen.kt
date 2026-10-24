package sa.edu.iau.cshj.studyplanner.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
data class PlannerUiState(
    val greeting: String = "Hello, Munirah",
    val totalTasks: Int = 7,
    val completedTasks: Int = 0,
    val tasks: List<String> = emptyList()
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onAddTaskClick: () -> Unit,
    onTaskClick: (String) -> Unit,
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

        uiState.tasks.forEach { task ->
            Button(onClick = { onTaskClick(task) }) {
                Text(task)
            }
        }
    }
}

@Preview(showBackground = true, name = "Nothing Done Yet")
@Composable
private fun PlannerHomeScreenNothingDonePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(completedTasks = 0, totalTasks = 7),
            onAddTaskClick = {},
            onTaskClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Everything Done")
@Composable
private fun PlannerHomeScreenEverythingDonePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(completedTasks = 7, totalTasks = 7),
            onAddTaskClick = {},
                    onTaskClick = {}
        )
    }
}
@Composable
fun PlannerHomeRoute(onTaskClick: (String) -> Unit) {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                tasks = listOf("Lab 5 report", "Math assignment", "Read chapter 4")
            )
        )
    }

    PlannerHomeScreen(
        uiState = uiState,
        onAddTaskClick = {
            uiState = uiState.copy(
                completedTasks = uiState.completedTasks + 1
            )
        },
        onTaskClick = onTaskClick
    )
}