package com.example.baitapvenhatuan2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.baitapvenhatuan2.ui.theme.BaiTapVeNhaTuan2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaiTapVeNhaTuan2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BaiTapTuan2App()
                }
            }
        }
    }
}

@Composable
fun BaiTapTuan2App() {
    var name by remember { mutableStateOf("") }
    var ageInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {
        Text(text = "THỰC HÀNH 01", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Họ và tên") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = ageInput,
            onValueChange = { ageInput = it },
            label = { Text("Tuổi") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val age = ageInput.toIntOrNull()
                result = if (age != null && age >= 0 && age in 0..150) {
                    when {
                        age > 65 -> "Người già"
                        age >= 6 -> "Người lớn"
                        age >= 2 -> "Trẻ em"
                        else -> "Em bé"
                    }
                } else {
                    "Vui lòng nhập số tuổi hợp lệ!"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kiểm tra")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (result.isNotEmpty()) {
            Text(text = "Xin chào $name, bạn là: $result", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
