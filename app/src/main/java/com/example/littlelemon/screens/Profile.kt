package com.example.littlelemon.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.composables.HeaderLogo
import com.example.littlelemon.composables.LLButton
import com.example.littlelemon.composables.LLInput
import com.example.littlelemon.destinations.Onboarding
import com.example.littlelemon.storage.UserPreferences
import com.example.littlelemon.storage.UserPreferences.getUser

@Composable
fun Profile(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val context = LocalContext.current
    val getUser = getUser(context)
    Column(modifier = modifier.fillMaxWidth().padding(20.dp, 0.dp)) {
        HeaderLogo(modifier = modifier.align(Alignment.CenterHorizontally))
        Text("Profile information",
            modifier= Modifier
                .padding(0.dp, 10.dp),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)

        )
        Text(
            "First Name",
            modifier= Modifier.padding(0.dp, 15.dp, 0.dp)
        )
        LLInput(
            text = getUser?.firstName ?: ""
        ){}
        Text(
            "Last Name",
            modifier= Modifier.padding(0.dp, 15.dp, 0.dp)
        )
        LLInput(
            text = getUser?.lastName ?: ""
        ){}
        Text(
            "Email:",
            modifier= Modifier.padding(0.dp, 15.dp, 0.dp)
        )
        LLInput(
            text = getUser?.email ?: ""
        ){}
        LLButton(
            text = "Log out",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp, 0.dp)
        ) {
            UserPreferences.clearUser(context)
            navHostController.navigate(Onboarding.route)
        }
    }
}

@Composable
@Preview
fun ProfilePreview(){
    val navHostController = rememberNavController()
    Profile(navHostController = navHostController)
}