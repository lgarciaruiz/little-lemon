import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LLButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        border = BorderStroke(1.dp, Color(0xFFEE9972)),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF4CE14),
            contentColor = Color(0XFF333333)
        ),
        modifier = modifier
    ) {
        Text(text)
    }
}

@Composable
@Preview
fun ButtonPreivew(){
    LLButton(text = "Click me") {
        // Do something when the button is clicked
    }
}