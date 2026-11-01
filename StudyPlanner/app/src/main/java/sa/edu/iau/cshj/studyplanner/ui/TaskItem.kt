package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskItem(
    task: StudyTask,
    onTaskClick: (Int) -> Unit,
    onDoneChange: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onTaskClick(task.id) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.isDone,
            onCheckedChange = { checked -> onDoneChange(task.id, checked) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = task.title, style = MaterialTheme.typography.titleMedium)
            Text(text = task.course, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskItemNotDonePreview() {
    TaskItem(
        task = StudyTask(1, "Lab 7", "CSC 402", false),
        onTaskClick = {},
        onDoneChange = { _, _ -> }
    )
}

@Preview(showBackground = true)
@Composable
fun TaskItemDonePreview() {
    TaskItem(
        task = StudyTask(2, "Lab 6", "CSC 402", true),
        onTaskClick = {},
        onDoneChange = { _, _ -> }
    )
}