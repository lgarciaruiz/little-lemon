import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

@Composable
fun Onboarding(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(0.dp, 40.dp)
                .width(150.dp)
        )
        Text(
            text = "Lets get to know you!",
            fontSize = 28.sp,
            color = Color(color = 0xFFFFFFFF),
            modifier = Modifier
                .background(Color(0xFF495E57))
                .fillMaxWidth()
                .padding(0.dp, 40.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OnboardInput(label = "First Name")
        Spacer(modifier = Modifier.padding(10.dp))
        OnboardInput(label = "Last Name")
        Spacer(modifier = Modifier.padding(10.dp))
        OnboardInput(label = "Email", placeholderText = "example@gmail.com")
        LLButton(text = "Register", modifier = Modifier.padding(20.dp).fillMaxWidth()) {
            // Do something when the button is clicked
        }
    }
}

@Composable
fun OnboardInput(label: String = "", placeholderText: String = "") {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        TextField(
            value = text,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            onValueChange = { text = it },
            label = { Text(label) },
            placeholder = { Text(text = placeholderText) },
            modifier = Modifier.fillMaxWidth()
                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
        )
    }
}

@Composable
@Preview
fun OnboardingPreview(){
    Onboarding()
}