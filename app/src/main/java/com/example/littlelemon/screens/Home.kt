package com.example.littlelemon.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.composables.HeaderLogo
import com.example.littlelemon.composables.Hero
import com.example.littlelemon.composables.MenuItems
import com.example.littlelemon.destinations.Profile
import com.example.littlelemon.storage.MenuItemRoom
import com.example.littlelemon.ui.theme.Gray
import com.example.littlelemon.ui.theme.Green

@Composable
fun Home(navHostController: NavHostController, menuItems: List<MenuItemRoom>, menuCategories: List<String>) {
    var searchPhrase by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<String?>(null) }
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

        Hero(searchPhrase = searchPhrase) {
            searchPhrase = it
        }

        //filter by category
        LazyRow {
            items(menuCategories){ category ->
                val isSelected = selectedCategory == category
                Button(
                    //save the selected category to a state variable; needs to be in a state to do something
                    onClick =  { selectedCategory = if (isSelected) null else category },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) Green else Gray,
                        contentColor = if (isSelected) Gray else Green
                    )
                ){
                    Text(text = category, fontWeight = FontWeight.Bold)
                }
            }
        }

        //filter by search phrase
        val filteredMenuItems = if (searchPhrase.isNotEmpty()) {
            menuItems.filter { it.title.contains(searchPhrase, ignoreCase = true) || it.description.contains(searchPhrase, ignoreCase = true) }
        } else if(selectedCategory != null) {
            menuItems.filter { it.category == selectedCategory }
        } else {
            menuItems
        }
        MenuItems(menuItems = filteredMenuItems)
    }
}