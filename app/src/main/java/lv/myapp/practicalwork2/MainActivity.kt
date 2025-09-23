package lv.myapp.practicalwork2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import lv.myapp.practicalwork2.ui.theme.PracticalWork2Theme
import androidx.compose.ui.unit.dp
import android.content.Intent;

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticalWork2Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column (
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .padding(vertical = 32.dp, horizontal = 32.dp)
        ) {
            SecondActivityBtn (
                onClick = {
                    context.startActivity(Intent(context, SecondActivity::class.java))
                }
            )
            DialogBtn {
                    Dialog(){}
            }
        }
    }
}

@Composable
fun SecondActivityBtn(onClick: () -> Unit) {
    Button(
        onClick = onClick,
    ) {
        Text(text = "Go to 2-nd")
    }
}
@Composable
fun DialogBtn(onClick: () -> Unit) {
    Button(
        onClick = onClick,
    ) {
        Text(text = "4. Group's Dialog")
    }
}

@Composable
fun Dialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}