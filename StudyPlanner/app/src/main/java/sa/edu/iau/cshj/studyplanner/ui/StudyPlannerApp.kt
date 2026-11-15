package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import sa.edu.iau.cshj.studyplanner.navigation.PlannerHome
import sa.edu.iau.cshj.studyplanner.navigation.TaskDetail

@Composable
fun StudyPlannerApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PlannerHome) {
        composable<PlannerHome> {
            PlannerHomeRoute(
                onNavigateToTask = { taskId ->
                    navController.navigate(route = TaskDetail(title = taskId.toString()))
                }
            )
        }
        composable<TaskDetail> { backStackEntry ->
            val detail: TaskDetail = backStackEntry.toRoute()
            TaskDetailRoute(
                title = detail.title,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}