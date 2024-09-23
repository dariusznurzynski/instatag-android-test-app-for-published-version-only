package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.bi_instatag.itandroidsdk.Instatag
import com.bi_instatag.itandroidsdk.IDType
import com.bi_instatag.itandroidsdk.VisitorType
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instatag.configure(this.application, "bee3bb07-d9a6-4c8b-ba5f-6a6f9b0815ce")

        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingWithButton("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingWithButton(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello $name!")

        Spacer(modifier = Modifier.height(16.dp)) // Add space between Text and Button

        Button(onClick = {
            // Action to perform when button is clicked
            Log.d("Button", "Button Clicked!")
            Instatag.trackScreen("My Application")

            Instatag.trackButton("First demo btn")
            Instatag.trackFormStart("demo form", "speciality", "medical info")
            Instatag.trackFormEnd("demo form", "speciality", "medical info")
            Instatag.trackSearch("whatsup", "42", "life")
            Instatag.trackLogin("user-id", "password", VisitorType.HCP, IDType.VeevaId)
            Instatag.trackRegistrationFormStart("reg form", "speciality", "medical info")
            Instatag.trackRegistrationFormEnd("reg form", "speciality", "medical info")
            Instatag.trackInputFieldChange("reg form", "firstname")
            Instatag.trackSoftAuth(VisitorType.HCP)
        }) {
            Text("Click Me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingWithButtonPreview() {
    MyApplicationTheme {
        GreetingWithButton("Android")
    }
}