package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onTaskClick: (Int) -> Unit,
    onDoneChange: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val total = uiState.tasks.size
    val done = uiState.tasks.count { it.isDone }

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Welcome Back!",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Progress: $done of $total done",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = uiState.tasks, key = { it.id }) { task ->
                TaskItem(
                    task = task,
                    onTaskClick = onTaskClick,
                    onDoneChange = onDoneChange
                )
            }
        }
    }
}

@Composable
fun PlannerHomeRoute(
    onNavigateToTask: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var tasks by remember {
        mutableStateOf(
            listOf(
                StudyTask(1, "Lab 7", "CSC 402", true),
                StudyTask(2, "Assignment 2", "MATH 201", false),
                StudyTask(3, "Read Chapter 4", "CSC 402", false),
                StudyTask(4, "Project Proposal", "ENG 301", false),
                StudyTask(5, "Quiz Prep", "PHYS 102", false)
            )
        )
    }

    PlannerHomeScreen(
        uiState = PlannerUiState(tasks = tasks),
        onTaskClick = onNavigateToTask,
        onDoneChange = { taskId, isDone ->
            tasks = tasks.map { task ->
                if (task.id == taskId) task.copy(isDone = isDone) else task
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PlannerHomeScreenPreview() {
    val sampleTasks = listOf(
        StudyTask(1, "Lab 7", "CSC 402", true),
        StudyTask(2, "Assignment 2", "MATH 201", false),
        StudyTask(3, "Read Chapter 4", "CSC 402", false),
        StudyTask(4, "Project Proposal", "ENG 301", false),
        StudyTask(5, "Quiz Prep", "PHYS 102", false)
    )
    PlannerHomeScreen(
        uiState = PlannerUiState(tasks = sampleTasks),
        onTaskClick = {},
        onDoneChange = { _, _ -> }
    )
}