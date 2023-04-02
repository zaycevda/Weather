package com.example.weather.app.ui.search

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.weather.app.ui.theme.Blue
import com.example.weather.app.ui.theme.Gray0
import com.example.weather.app.ui.theme.Gray1

@Composable
fun SearchDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .border(
                    width = 1.dp,
                    color = Gray0,
                    shape = RoundedCornerShape(16.dp)
                ),
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Gray1
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 15.dp)
            ) {
                Text(
                    text = "Поиск",
                    modifier = Modifier.padding(bottom = 4.dp),
                    style = TextStyle(
                        color = Blue,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                var text by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = text,
                    onValueChange = { newText ->
                        text = newText
                    },
                    label = {
                        Text(
                            text = "Город",
                            style = TextStyle(
                                color = Blue,
                                fontSize = 16.sp
                            )
                        )
                    },
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = {
                            onConfirm(text)
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Send,
                                tint = Blue,
                                contentDescription = "Search city"
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {
                        onConfirm(text)
                    }),
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedLabelColor = Color.White,
                        focusedLabelColor = Blue,
                        unfocusedBorderColor = Color.White,
                        focusedBorderColor = Blue,
                        textColor = Blue,
                        cursorColor = Blue
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun SearchDialogPreview() {
    SearchDialog(
        onDismiss = {},
        onConfirm = {}
    )
}