package com.example.littlelemon.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.littlelemon.composables.HeaderLogo

@Composable
fun Home() {
    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderLogo()
    }
}