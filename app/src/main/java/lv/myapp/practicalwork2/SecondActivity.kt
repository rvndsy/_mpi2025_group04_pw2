package lv.myapp.practicalwork2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import lv.myapp.practicalwork2.ui.theme.PracticalWork2Theme
import androidx.compose.ui.unit.dp
import android.content.Intent;
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PracticalWork2Theme {
                SecondScreen()
            }
        }
    }
}

@Composable
@Preview
fun SecondScreen() {
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column (
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("2-nd Activity", fontSize = 24.sp, modifier=Modifier.padding(16.dp))
            BackBtn (
                onClick = {
                    context.startActivity(Intent(context, MainActivity::class.java))
                }
            )
        }
    }
}
@Composable
fun BackBtn(onClick: () -> Unit) {
    Button(
        onClick = onClick,
    ) {
        Text(text = "Back")
    }
}
