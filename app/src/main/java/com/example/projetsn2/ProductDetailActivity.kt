package com.example.projetsn2

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetsn2.ui.theme.Projetsn2Theme

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productName = intent.getStringExtra("product_name") ?: "Produit inconnu"
        val productDesc = intent.getStringExtra("product_desc") ?: "Description non disponible"
        val productImage = intent.getIntExtra("product_image", R.drawable.default_image)
        setContent {
            Projetsn2Theme {
                Surface {
                    ProductDetailScreen(productName, productDesc, productImage)
                }
            }
        }
    }
}

@Composable
fun ProductDetailScreen(name: String, description: String, imageRes: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(name, fontSize = 24.sp)
        Text(description, fontSize = 16.sp)
    }
}
