package com.theapplication.satyamanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theapplication.satyamanimation.Gamepad.Screen.HomeScreen
import com.theapplication.satyamanimation.ThreadCard.ThreadsInviteCard
import com.theapplication.satyamanimation.ui.theme.SatyamAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SatyamAnimationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                      modifier = Modifier.padding(innerPadding))

                    {
                       // ThreadsInviteCard()
                        HomeScreen()
                    }

                }
            }
        }
    }
}

