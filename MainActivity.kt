package com.threetrees.unittesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.threetrees.unittesting.ui.theme.UnitTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RandomNameChanger()
                }
            }
        }
    }
}

@Composable
fun RandomNameChanger() {
    var currentName by remember { mutableStateOf("John Doe") }

    val names = listOf(
        "John Doe",
        "Jane Smith",
        "Alice Johnson",
        "Bob Brown",
        "Ella Wilson"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                currentName = names.random()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Change Name")
        }
        Text(text = currentName, modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
fun RandomNameChangerPreview() {
    RandomNameChanger()
}