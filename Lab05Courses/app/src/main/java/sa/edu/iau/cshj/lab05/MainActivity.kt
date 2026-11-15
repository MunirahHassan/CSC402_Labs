package sa.edu.iau.cshj.lab05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import sa.edu.iau.cshj.lab05.ui.HomeRoute
import sa.edu.iau.cshj.lab05.ui.theme.Lab05CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab05CoursesTheme {
                HomeRoute(onCoursesClick = {})
            }
        }
    }
}