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

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PracticalWork2Theme {  // 👈 Apply the same theme here
                SecondScreen()     // 👈 Your composable for this screen
            }
        }
    }
}

@Composable
fun SecondScreen() {
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column (
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .padding(vertical = 32.dp, horizontal = 32.dp)
        ) {
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
        Text(text = "Go Back")
    }
}
