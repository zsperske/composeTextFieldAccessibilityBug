package com.sperske.textfieldaccessibilitybug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import com.sperske.textfieldaccessibilitybug.ui.theme.Theme
import kotlinx.coroutines.job

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Theme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          Column {
            Button(onClick = { }) {
              Text("Some Button")
            }

            var value: String by remember { mutableStateOf("") }
            TextField(value = value, onValueChange = { value = it })

            Button(onClick = { }) {
              Text("Another Button")
            }

            var anotherValue: String by remember { mutableStateOf("") }
            var isError: Boolean by remember { mutableStateOf(false) }
            val focusRequester: FocusRequester  by remember { mutableStateOf(FocusRequester()) }

            TextField(
              modifier = Modifier.focusRequester(focusRequester).focusable(),
              value = anotherValue,
              onValueChange = { anotherValue = it },
              isError = isError,
              placeholder = {
                Text("Some Placeholder")
              },
              label = {
                Text("Some Label")
              }
            )

            Button(onClick = {
              isError = !isError
              // This only works one time
              focusRequester.requestFocus()
            }) {
              Text("Toggle Error State")
            }
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  Theme {
    Greeting("Android")
  }
}