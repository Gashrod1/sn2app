package com.example.projetsn2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
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
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Banner("Rayons")
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RayonButton("Boissons", Color(0xFF1E88E5)) {
                val intent = Intent(context, RayonActivity::class.java).apply {
                    putExtra("rayon", "boissons")
                }
                context.startActivity(intent)
            }
            RayonButton("Nourriture", Color(0xFF43A047)) {
                val intent = Intent(context, RayonActivity::class.java).apply {
                    putExtra("rayon", "nourriture")
                }
                context.startActivity(intent)
            }
            RayonButton("Cartes Graphiques", Color(0xFFD32F2F)) {
                val intent = Intent(context, RayonActivity::class.java).apply {
                    putExtra("rayon", "cartes_graphiques")
                }
                context.startActivity(intent)
            }
        }
    }
}

@Composable
fun RayonButton(text: String, color: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp, pressedElevation = 8.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}
