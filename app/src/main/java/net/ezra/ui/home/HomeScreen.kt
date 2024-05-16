package net.ezra.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_PRODUCTS
//import net.ezra.navigation.ROUTE_SHOP

import net.ezra.R
import net.ezra.navigation.ROUTE_CONTACT
//import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_PRO_SCREEN
import net.ezra.navigation.ROUTE_VIEW_PROD

//import net.ezra.navigation.ROUTE_OURSTORE


//import net.ezra.navigation.ROUTE_VOUCHER


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun HomeScreen(navController: NavHostController) {

    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }





    Box {


        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "WELCOME TO THE MARKET PLACE")
                    },
                    navigationIcon = @Composable {
                        if (!isDrawerOpen) {
                            IconButton(onClick = { isDrawerOpen = true }) {
                                Icon(
                                    Icons.Default.Menu,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }
                        }
                    },

                    actions = {
                        IconButton(onClick = {
                            navController.navigate(ROUTE_LOGIN) {
                                popUpTo(ROUTE_HOME) { inclusive = true }
                            }

                        }) {
                            Icon(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    },

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xff0FB06A),
                        titleContentColor = Color.White,

                        )

                )
            },










            content = @Composable{
                
                Box(

                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            if (isDrawerOpen) {
                                isDrawerOpen = false
                            }
                        }


                ) {


                    Column(
                        modifier = Modifier
                            .background(Color(0xff09c3d0))
                            .fillMaxSize()
                            .padding(10.dp)
                            .padding(top = 10.dp),


                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Image(
                            painter = painterResource(R.drawable.name),
                            contentDescription = "Circle Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(128.dp)
                                .clip(CircleShape) // clip to the circle shape
                                .border(5.dp, Color.Magenta, CircleShape)//optional
                        )


                        Spacer(modifier = Modifier.height(20.dp))


                        Text(
                            text = stringResource(id = R.string.call),
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable {

                                    val intent = Intent(Intent.ACTION_DIAL)
                                    intent.data = Uri.parse("tel:+254722479333")

                                    callLauncher.launch(intent)
                                }
                        )

                        Text(
                            text = ( "developed with love by olivia"),
                            fontSize = 20.sp,
                        )










                        Spacer(modifier = Modifier.height(30.dp))











                        Button(onClick = {
                            navController.navigate(ROUTE_PRO_SCREEN) {
                                popUpTo(ROUTE_HOME) { inclusive = true }
                            }
                        }) {

                            Text(
                                text = "WE HAVE AMAZING PRODUCTS",
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                textDecoration = TextDecoration.LineThrough,
                                fontFamily = FontFamily.Cursive,
                                color = (Color.White)


                            )

                        }


                        Text(
                            modifier = Modifier

                                .clickable {
                                    navController.navigate(ROUTE_CONTACT) {
                                        popUpTo(ROUTE_HOME) { inclusive = true }
                                    }
                                },
                            text = "contact us",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
//                                fontSize = 20.sp,
//                                textAlign = TextAlign.Center ,
//                                textDecoration = TextDecoration.LineThrough,
//                                fontFamily = FontFamily.Cursive,
                            color = (Color.Red)
                        )









                        Spacer(modifier = Modifier.height(30.dp))



                        LazyRow(modifier = Modifier.fillMaxWidth()) {
                            item {


                                Card(
                                    onClick = {
                                        navController.navigate(ROUTE_PRODUCTS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }, modifier = Modifier
                                        .padding(15.dp)
                                        .height(150.dp)
                                        .width(150.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Absolute.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.background(
                                            Color.White
                                        )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.image4),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .size(100.dp)
                                                .height(500.dp)
                                                .width(250.dp)
                                        )
                                        Text(text = " baby clothes")
                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(
                                    onClick = {
                                        navController.navigate(ROUTE_PRODUCTS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }, modifier = Modifier
                                        .padding(15.dp)
                                        .height(150.dp)
                                        .width(150.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Absolute.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.background(
                                            Color.White
                                        )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.image1),
                                            contentDescription = "",
                                            modifier = Modifier.size(70.dp)
                                        )
                                        Text(text = " wedding dresses")
                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(
                                    onClick = {
                                        navController.navigate(ROUTE_HOME) {
                                            popUpTo(
                                                ROUTE_PRODUCTS
                                            )
                                        }
                                    },
                                    modifier = Modifier
                                        .padding(15.dp)
                                        .height(150.dp)
                                        .width(150.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Absolute.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.background(
                                            Color.White
                                        )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.image3),
                                            contentDescription = "",
                                            modifier = Modifier.size(70.dp)
                                        )
                                        Text(text = "Cool cars")
                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(
                                    onClick = {
                                        navController.navigate(ROUTE_PRODUCTS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }, modifier = Modifier
                                        .padding(15.dp)
                                        .height(150.dp)
                                        .width(150.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Absolute.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.background(
                                            Color.White
                                        )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.stock),
                                            contentDescription = "",
                                            modifier = Modifier.size(70.dp)
                                        )
                                        Text(text = " food ingredients")
                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))


                                Card(
                                    onClick = {
                                        navController.navigate(ROUTE_PRODUCTS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }, modifier = Modifier
                                        .padding(15.dp)
                                        .height(150.dp)
                                        .width(150.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Absolute.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.background(
                                            Color.White
                                        )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.photo1),
                                            contentDescription = "",
                                            modifier = Modifier.size(70.dp)
                                        )
                                        Text(text = " Smart phones")
                                    }
                                }

                                Spacer(modifier = Modifier.width(15.dp))



                                Card(
                                    onClick = {
                                        navController.navigate(ROUTE_PRODUCTS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }, modifier = Modifier
                                        .padding(15.dp)
                                        .height(150.dp)
                                        .width(150.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Absolute.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.background(
                                            Color.White
                                        )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.image2),
                                            contentDescription = "",
                                            modifier = Modifier.size(70.dp)
                                        )
                                        Text(text = " BABY TOYS")
                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(
                                    onClick = {
                                        navController.navigate(ROUTE_PRODUCTS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }, modifier = Modifier
                                        .padding(15.dp)
                                        .height(150.dp)
                                        .width(150.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Absolute.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.background(
                                            Color.White
                                        )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.image5),
                                            contentDescription = "",
                                            modifier = Modifier.size(70.dp)
                                        )
                                        Text(text = " Amazing shoes")
                                    }
                                }


                            }

                        }


                    }


                }
            },




            bottomBar = { BottomBar() }
        )


    }



}





@Composable
fun BottomBar() {



    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color(0xff0FB06A)

    )


    {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"", tint = Color.White)
        },
            label = { Text(text = "Home",color =  Color.White) }, selected = (selectedIndex.value == 0), onClick = {

            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Favorite, "")
        },
            label = { Text(text = "Favorite") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person, "")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })
    }
}




































@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}



























