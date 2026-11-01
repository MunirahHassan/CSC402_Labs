package sa.edu.iau.cshj.studyplanner.ui

data class StudyTask(
    val id: Int,
    val title: String,
    val course: String,
    val isDone: Boolean = false
)

data class PlannerUiState(
    val tasks: List<StudyTask> = emptyList()
)