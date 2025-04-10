package com.example.littlelemon.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LLInput(
    modifier: Modifier = Modifier,
    label: String? = null,
    text: String,
    placeholderText: String = "",
    showError: Boolean = false,
    onChange: (String)-> Unit
) {
    TextField(
        value = text,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            errorContainerColor = Color.White,
            errorIndicatorColor = Color.White
        ),
        isError = showError,
        onValueChange = { onChange(it) },
        //notice if statement is outside of Unit
        label = if (label.isNullOrEmpty()) null else { { Text(label) } },
        placeholder = { Text(text = placeholderText) },
        modifier = modifier.fillMaxWidth()
            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
    )
    if(showError) {
        Text(
            text = "This field is required",
            color = Color.Red,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}

@Composable
@Preview
fun LLInputPreview() {
    LLInput(
        label = "First Name",
        text = "",
        placeholderText = "First Name",
        showError = false,
        onChange = {}
    )
}
