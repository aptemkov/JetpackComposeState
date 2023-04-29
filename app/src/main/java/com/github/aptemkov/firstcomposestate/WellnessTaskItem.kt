package com.github.aptemkov.firstcomposestate

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.aptemkov.firstcomposestate.ui.theme.FirstComposeStateTheme

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
        backgroundColor = when(checked) {
            true -> Color.Yellow
            else -> Color.Red
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                text = taskName
            )
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
            IconButton(onClick = onClose) {
                Icon(Icons.Filled.Close, contentDescription = "Close")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    FirstComposeStateTheme {
        WellnessTaskItem(
            taskName = "name", checked = true , onCheckedChange = { println(it)} , onClose = { /*TODO*/ })
    }
}