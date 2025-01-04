package com.example.projetsn2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetsn2.ui.theme.Projetsn2Theme

class StudentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val studentName = intent.getStringExtra("student_name") ?: "Student"
        setContent {
            Projetsn2Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    StudentScreen(studentName)
                }
            }
        }
    }
}

@Composable
fun StudentScreen(studentName: String) {
    val email = when (studentName) {
        "Ethan" -> "ethan.rampnoux@ecoles-epsi.net"
        "Matt" -> "matt.peau@ecoles-epsi.net"
        else -> "student@ecoles-epsi.net"
    }
    val imageRes = when (studentName) {
        "Ethan" -> R.drawable.ethan
        "Matt" -> R.drawable.matt
        else -> null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Banner(studentName)
        Spacer(modifier = Modifier.height(16.dp))
        imageRes?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = email, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(8.dp))
        val context = LocalContext.current
        Text(
            text = "www.epsi.fr",
            color = Color.Blue,
            modifier = Modifier
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.epsi.fr"))
                    context.startActivity(intent)
                }
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Banner(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = Color.White, fontSize = 20.sp)
    }
}