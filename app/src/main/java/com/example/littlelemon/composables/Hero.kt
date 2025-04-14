package com.example.littlelemon.composables
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.Green
import com.example.littlelemon.ui.theme.White
import com.example.littlelemon.ui.theme.Yellow

@Composable
fun Hero(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.background(Green).padding(20.dp)) {
        Text(
            "Little Lemon",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Yellow
            )
        Row(modifier = Modifier.fillMaxWidth().padding(0.dp, 10.dp)) {
            Column {
                Text(
                    "Chicago",
                    fontSize = 30.sp,
                    color = White,
                    modifier = Modifier.padding(bottom =  10.dp)
                )
                Text(
                    "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                    Modifier.fillMaxWidth(0.6f).padding(end = 10.dp),
                    color = White,
                )
            }
            Image(
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Hero Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(150.dp).clip(RoundedCornerShape(20.dp))
            )
        }

    }
}

@Composable
@Preview
fun HeroPreview() {
    Hero()
}