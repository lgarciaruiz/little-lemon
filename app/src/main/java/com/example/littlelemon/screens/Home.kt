package com.example.littlelemon.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.composables.HeaderLogo
import com.example.littlelemon.composables.Hero
import com.example.littlelemon.destinations.Profile

@Composable
fun Home(navHostController: NavHostController) {
    Column {
        Box(modifier = Modifier.fillMaxWidth().padding(20.dp, 5.dp)) {
            HeaderLogo(
            modifier = Modifier.align(Alignment.Center)
        )
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Profile Picture",
                modifier = Modifier.clip(shape = CircleShape)
                    .width(50.dp)
                    .align(Alignment.CenterEnd)
                    .clickable { navHostController.navigate(Profile.route) }
            ) }

        Hero()
    }
}