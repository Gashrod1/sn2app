package com.example.projetsn2

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projetsn2Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
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
            ButtonRow()
        }
    }
}

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "EPSI", color = Color.White, fontSize = 20.sp)
    }
}

@Composable
fun ButtonRow() {
    val context = androidx.compose.ui.platform.LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SquareButton("Info") {
            Log.d("MainActivity", "Info button clicked")
            val newIntent = Intent(context, InfoActivity::class.java)
            context.startActivity(newIntent)
        }
        SquareButton("Products") {
            Log.d("MainActivity", "Products button clicked")
            val newIntent = Intent(context, ProductsActivity::class.java)
            context.startActivity(newIntent)
        }
    }
}

@Composable
fun SquareButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(100.dp)
            .background(Color.Gray)
    ) {
        Text(text = text)
    }
}