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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import lv.myapp.practicalwork2.ui.theme.PracticalWork2Theme
import androidx.compose.ui.unit.dp
import android.content.Intent
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

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
@Preview
fun MainScreen() {
    val context = LocalContext.current
    // manage dialog state
    // changes to the variable force recomposition of composables that use it
    // use by instead of = to preserve the type and not have to do .value
    var showDialog by remember { mutableStateOf(false) }
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    if (showDialog) {
        Dialog (
            onDismissRequest = { showDialog = false },
            dialogTitle = "#4 Group's Dialog",
            onConfirmation = { showDialog = false }
        ) {
            DialogContent(
                checked1 = checked1,
                checked2 = checked2,
                onChecked1Change = {
                    // "it" is the default arg of 1 arg lambdas
                    checked1 = it
                },
                onChecked2Change = {
                    checked2 = it
                }
            )
        }
    }

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
            DialogBtn (
                onClick = {
                    showDialog = true
                }
            )
        }
    }
}

@Composable
fun SecondActivityBtn(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Go to 2-nd")
    }
}
@Composable
fun DialogBtn(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Dialog")
    }
}

@Composable
fun Dialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    // trailing lambda syntax
    content: @Composable () -> Unit = {}
) {
    AlertDialog(
        title = { Text(text = dialogTitle) },
        onDismissRequest = { onDismissRequest() },
        confirmButton = { TextButton(onClick = { onConfirmation() })
            {
                Text("OK")
            }
        },
        dismissButton = { TextButton(onClick = { onDismissRequest() })
            {
                Text("Close")
            }
        },
        text = { content() }
    )
}

@Composable
fun DialogContent(
    checked1: Boolean,
    checked2: Boolean,
    onChecked1Change: (Boolean) -> Unit,
    onChecked2Change: (Boolean) -> Unit
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked1,
                onCheckedChange = onChecked1Change
            )
            Text("Ričards Didriksons")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked2,
                onCheckedChange = onChecked2Change
            )
            Text("Elvis Ritiņš")
        }
    }
}

@Composable
@Preview
fun DialogPreview() {
    Dialog (
        onDismissRequest = {},
        onConfirmation = {},
        dialogTitle = "Preview",
        content = { DialogContent(
            checked1 = false,
            checked2 = true,
            onChecked1Change = {},
            onChecked2Change = {}
        ) }
    )
}