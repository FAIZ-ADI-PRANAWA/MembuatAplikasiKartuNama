package com.example.FaizAdiParanawa


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FaizAdiParanawa.ui.theme.MembuatAplikasiKartuNamaTheme

// Activity utama aplikasi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MembuatAplikasiKartuNamaTheme {
                // Menggunakan Scaffold untuk membuat struktur dasar UI
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Memanggil Composable BusinessCard dengan padding dari Scaffold
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    // Menggunakan Column untuk menyusun elemen secara vertikal
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Menampilkan gambar logo
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "Logo Android",
            modifier = Modifier
                .size(200.dp)
                .padding(4.dp)
                .background(Color.Black)
        )
        // Menampilkan nama
        Text(
            text = "Faiz Adi Pranawa",
            fontSize = 30.sp,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        // Menampilkan deskripsi pekerjaan
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 18.sp,
            color = Color(0xFF3ddc84),
            modifier = Modifier.padding(8.dp)
        )
        // Menambahkan spacer untuk jarak
        Spacer(modifier = Modifier.height(32.dp))
        // Menampilkan baris informasi kontak
        ContactInfoRow(icon = R.drawable.phone, color = Color(0xFF3ddc84), info = "089612677924")
        ContactInfoRow(icon = R.drawable.share, info = "@AndroidDev", color = Color(0xFF3ddc84))
        ContactInfoRow(
            icon = R.drawable.email,
            info = "faiz.adi@students.utdi.ac.id",
            color = Color(0xFF3ddc84)
        )
    }
}



@Composable
fun ContactInfoRow(icon: Int, info: String, color: Color) {
    // Menggunakan Row untuk menyusun ikon dan teks secara horizontal
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Menampilkan ikon
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .padding(end = 16.dp),
            colorFilter = ColorFilter.tint(color)
        )
        // Menampilkan teks informasi kontak
        Text(
            text = info,
            fontSize = 16.sp,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCard()
}