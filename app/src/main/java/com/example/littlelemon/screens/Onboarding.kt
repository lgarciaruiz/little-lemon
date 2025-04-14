package com.example.littlelemon.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.composables.HeaderLogo
import com.example.littlelemon.composables.LLButton
import com.example.littlelemon.composables.LLInput
import com.example.littlelemon.destinations.Home
import com.example.littlelemon.model.User
import com.example.littlelemon.storage.UserPreferences

@Composable
fun Onboarding(modifier: Modifier = Modifier, navHostController: NavHostController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(modifier = modifier.fillMaxWidth()) {
        HeaderLogo(modifier = Modifier.align(Alignment.CenterHorizontally))
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
        Column(modifier = Modifier.padding(20.dp,0.dp)) {
            Spacer(modifier = Modifier.padding(10.dp))
            LLInput(label = "First Name", text = firstName, showError = showError && firstName.isEmpty()){firstName = it}
            Spacer(modifier = Modifier.padding(10.dp))
            LLInput(label = "Last Name", text = lastName, showError = showError && lastName.isEmpty()){lastName = it}
            Spacer(modifier = Modifier.padding(10.dp))
            LLInput(label = "Email", text = email, placeholderText = "example@gmail.com", showError = showError && email.isEmpty()){email = it}
           }
        LLButton(text = "Register", modifier = Modifier.padding(20.dp).fillMaxWidth()) {
            if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                showError = true
            } else {
                val user = User(firstName, lastName, email)
                //save user to shared preferences and navigate to home screen
                UserPreferences.saveUser(context, user)
                navHostController.navigate(Home.route)
            }
        }
    }
}

@Composable
@Preview
fun OnboardingPreview(){
    val navController = rememberNavController()
    Onboarding(navHostController = navController)
}