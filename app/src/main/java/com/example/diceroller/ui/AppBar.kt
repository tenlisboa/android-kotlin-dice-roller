package com.example.diceroller.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import com.example.diceroller.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(onOptionSelected: (Int) -> Unit) {
    var isExpandedMenu by remember {
        mutableStateOf(false)
    }

    TopAppBar(title = { Text(stringResource(id = R.string.app_name)) }, actions = {
        Row {
            Box {
                IconButton(
                    onClick = { isExpandedMenu = !isExpandedMenu }
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Default.MoreVert),
                        contentDescription = stringResource(
                            id = R.string.options
                        ),
                    )
                }
                DropdownMenu(
                    expanded = isExpandedMenu,
                    onDismissRequest = { isExpandedMenu = false }) {
                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.option_1)) },
                        onClick = {
                            onOptionSelected(1)
                            isExpandedMenu = false
                        })
                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.option_2)) },
                        onClick = {
                            onOptionSelected(2)
                            isExpandedMenu = false
                        })
                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.option_3)) },
                        onClick = {
                            onOptionSelected(3)
                            isExpandedMenu = false
                        })
                }
            }
        }
    })

}