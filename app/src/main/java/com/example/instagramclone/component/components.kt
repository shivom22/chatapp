@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.instagramclone.component
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramclone.R

@Composable
fun normaltext(value: String){
    Text(text = value,
         modifier = Modifier
             .fillMaxWidth()
             .heightIn(min = 40.dp),
         style = TextStyle(
             fontSize = 24.sp,
             fontWeight = FontWeight.Normal,
             fontStyle = FontStyle.Normal
         ),
        color = colorResource(id = R.color.colortxt),
        textAlign = TextAlign.Center
         )
}

@Composable
fun headingnormaltext(value: String){
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colortxt),
        textAlign = TextAlign.Center
    )
}


@Composable
fun textfield(labelvalue:String,painter: Painter){
    val txtvalue = remember {
       mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        label = { Text(text = labelvalue)},
        colors =TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorprimary),
            focusedLabelColor = colorResource(id = R.color.colorprimary),
            cursorColor = colorResource(id = R.color.colorprimary),
            containerColor = colorResource(id = R.color.geryish)
        ) ,
        keyboardOptions = KeyboardOptions.Default,
        value = txtvalue.value, onValueChange = {
        txtvalue.value=it
    },
        leadingIcon = {
            Icon(painter, contentDescription ="" )
        }
    )
}


@Composable
fun passwordtextfield(labelvalue:String,painter: Painter){
    val password = remember {
        mutableStateOf("")
    }
    val   passwordvisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        label = { Text(text = labelvalue)},
        colors =TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorprimary),
            focusedLabelColor = colorResource(id = R.color.colorprimary),
            cursorColor = colorResource(id = R.color.colorprimary),
            containerColor = colorResource(id = R.color.geryish)
        ) ,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value, onValueChange = {
            password.value=it
        },
        leadingIcon = {
            Icon(painter, contentDescription ="" )
        },
        trailingIcon = {
            val iconimage= if(passwordvisible.value){
               Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            var description = if(passwordvisible.value){
                stringResource(id = R.string.hide_password)
            }else{
                 stringResource(id = R.string.show_password)
            }
            IconButton(onClick = { passwordvisible.value = !passwordvisible.value }) {
                  Icon(imageVector = iconimage, contentDescription =description )
            }
        },
        visualTransformation = if(passwordvisible.value) VisualTransformation.None else PasswordVisualTransformation()

    )
}
