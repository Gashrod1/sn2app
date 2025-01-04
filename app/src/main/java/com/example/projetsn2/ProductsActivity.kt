package com.example.projetsn2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetsn2.ui.theme.Projetsn2Theme

class ProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projetsn2Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ProductsScreen()
                }
            }
        }
    }
}

@Composable
fun ProductsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Banner()
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ProductsRectangleButtonRow()
        }
    }
}

@Composable
fun ProductsRectangleButtonRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ProductsRectangleButton("Button 1") {
            // Handle Button 1 click
        }
        ProductsRectangleButton("Button 2") {
            // Handle Button 2 click
        }
    }
}

@Composable
fun ProductsRectangleButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(150.dp)
            .height(50.dp)
            .background(Color.Gray, shape = RoundedCornerShape(8.dp))
    ) {
        Text(text = text)
    }
}