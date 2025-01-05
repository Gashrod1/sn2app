package com.example.projetsn2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetsn2.ui.theme.Projetsn2Theme

data class Product(
    val name: String,
    val description: String,
    val imageRes: Int
)

class RayonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rayon = intent.getStringExtra("rayon") ?: "Rayon inconnu"

        Log.d("RayonActivity", "Rayon sélectionné : $rayon")

        setContent {
            Projetsn2Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    RayonScreen(rayon)
                }
            }
        }
    }
}

@Composable
fun RayonScreen(rayon: String) {
    val context = LocalContext.current

    val products = when (rayon) {
        "boissons" -> listOf(
            Product("Coca", "Un soda pétillant au goût classique.", R.drawable.coca),
            Product("Fanta", "Une boisson à l'orange pétillante.", R.drawable.fanta),
            Product("Redbull", "Une boisson énergisante populaire.", R.drawable.redbull)
        )
        "nourriture" -> listOf(
            Product("Pizza", "Une délicieuse pizza au fromage.", R.drawable.pizza),
            Product("Burger", "Un burger juteux avec du bacon.", R.drawable.burger),
            Product("Tacos", "Un tacos épicé et savoureux.", R.drawable.tacos)
        )
        "cartes_graphiques" -> listOf(
            Product("NVIDIA RTX 3060", "Une carte puissante pour les gamers.", R.drawable.rtx3060),
            Product("AMD RX 6700 XT", "Une performance incroyable à bon prix.", R.drawable.rx6700xt),
            Product("Intel ARC A770", "Une nouvelle ère de cartes graphiques.", R.drawable.arc_a770)
        )
        else -> emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Produits - $rayon",
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        // Liste des produits
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(products.size) { index ->
                val product = products[index]
                ProductRow(product) {
                    val intent = Intent(context, ProductDetailActivity::class.java).apply {
                        putExtra("product_name", product.name)
                        putExtra("product_desc", product.description)
                        putExtra("product_image", product.imageRes)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun ProductRow(product: Product, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(product.name, fontSize = 18.sp, color = Color.Black)
            Text(product.description, fontSize = 14.sp, color = Color.Gray)
        }
    }
}
