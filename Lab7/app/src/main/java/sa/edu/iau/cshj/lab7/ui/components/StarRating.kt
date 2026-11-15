package sa.edu.iau.cshj.lab07.ui.components

import android.widget.RatingBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun StarRating(
    stars: Float,
    onStarsChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            RatingBar(context).apply {
                numStars = 5
                stepSize = 0.5f
                // TODO 1: add a listener
                setOnRatingBarChangeListener { _, value, fromUser ->
                    if (fromUser) onStarsChange(value)
                }
            }
        },
        update = { view ->
            // TODO 2: update
            view.rating = stars
        }
    )
}
