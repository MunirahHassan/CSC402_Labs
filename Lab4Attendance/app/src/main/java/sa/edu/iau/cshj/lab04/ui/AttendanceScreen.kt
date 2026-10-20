package sa.edu.iau.cshj.lab04.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class AttendanceUiState(
    val sessionTitle: String = "",
    val checkedInCount: Int = 0,
    val isCheckedIn: Boolean = false
)
@Composable
fun AttendanceScreen(
    uiState: AttendanceUiState,
    onCheckIn: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            text = uiState.sessionTitle,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(text = "Checked in: ${uiState.checkedInCount}")
        Button(
            onClick = onCheckIn,
            enabled = !uiState.isCheckedIn
        ) {
            Text(if (uiState.isCheckedIn) "Checked in" else "Check in")
        }
    }
}
@Preview(showBackground = true, name = "Not checked in yet")
@Composable
private fun AttendanceScreenPreview() {
    MaterialTheme {
        Surface {
            AttendanceScreen(
                uiState = AttendanceUiState("CSC 402 - Week 4", 12, false),
                onCheckIn = {}
            )
        }
    }
}
@Preview(showBackground = true, name = "Already checked in")
@Composable
private fun AttendanceScreenCheckedInPreview() {
    MaterialTheme {
        Surface {
            AttendanceScreen(
                uiState = AttendanceUiState("CSC 402 - Week 4", 13, true),
                onCheckIn = {}
            )
        }
    }
}