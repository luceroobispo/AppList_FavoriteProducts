package com.luceroobispo.applist_favoriteproducts.feature_home.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Scaffold { paddingValues->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            GlideImage(
                imageModel = {"https://cdn-icons-png.flaticon.com/512/4601/4601858.png"},
                modifier = Modifier.size(200.dp)
            )
            WelcomeButton(text="Find Product", onClick = { navController.navigate("ProductListScreen") })
            WelcomeButton(text ="Favourite Product", onClick = {navController.navigate("FavoriteProductsScreen")})
        }
    }
}

@Composable
fun WelcomeButton(text: String, onClick:()->Unit) {
    Button(modifier = Modifier
        .padding(50.dp, 5.dp)
        .fillMaxWidth(),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow,
            contentColor = Color.Black,
        ),
    ) {
        Text(text = text)
    }
}
