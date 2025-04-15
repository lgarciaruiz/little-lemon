package com.example.littlelemon.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.storage.MenuItemRoom

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItems(menuItems: List<MenuItemRoom>) {
    //lazy column is a composable that allows us to display a list of items in a scrollable list
    LazyColumn {
        items(items = menuItems) { menuItem ->
                Row(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                    Column(modifier = Modifier.weight(.6f).padding(end = 20.dp)){
                        Text(
                            text = menuItem.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = menuItem.description,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "$${menuItem.price}",
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                    GlideImage(
                        model = menuItem.image,
                        contentDescription = menuItem.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                    )
                }
        }
    }
}