package com.example.instagramclone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramclone.R
import com.example.instagramclone.component.headingnormaltext
import com.example.instagramclone.component.normaltext
import com.example.instagramclone.component.passwordtextfield
import com.example.instagramclone.component.textfield

@Composable
fun signupscreen (){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
            .padding(28.dp)
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            normaltext(value = stringResource(id = R.string.hey_there))
            headingnormaltext(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            textfield(labelvalue = stringResource(id = R.string.firstname), painter = painterResource(
                id = R.drawable.baseline_person_24
            ))
            textfield(labelvalue = stringResource(id = R.string.lastname), painter = painterResource(
                id = R.drawable.baseline_person_24
            ))
            textfield(labelvalue = stringResource(id = R.string.email), painter = painterResource(id = R.drawable.baseline_email_24))
            passwordtextfield(labelvalue = stringResource(id = R.string.password), painter = painterResource(
                id = R.drawable.baseline_lock_24))
        }

    }
}




@Composable
@Preview
fun suPreview(){
    signupscreen()
}