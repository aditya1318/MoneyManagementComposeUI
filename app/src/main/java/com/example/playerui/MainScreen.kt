package com.example.playerui

import android.app.Notification
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainScreen {


    @Composable
    fun Screen() {
        var state = rememberScrollState()
        Column(
            Modifier.scrollable(orientation = Orientation.Vertical,state = state,enabled = true)

                .fillMaxSize()
                .background(
                    Color(38, 21, 41, 255)
                )
        ) {

            TopProfilePicBar()

            GreetingText("Jeet Shah", modifier = Modifier.padding(start = 15.dp))

            DebitCard(
                modifier = Modifier
                    .padding(15.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            AddNewCardButton(

                modifier = Modifier

                    .padding(start = 15.dp, end = 15.dp)


                    .clip(shape = RoundedCornerShape(20))
            )

            Menu(
                menuList = listOf(
                    MenuItemsString("Savings"),
                    MenuItemsString("Transactions"), MenuItemsString
                        ("Currency")
                ),
                modifier = Modifier.padding(18.dp)
            )

            Chart(modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 20.dp)
                .clip(
                    RoundedCornerShape(20)
                ))

        }
    }

    @Composable
    fun TopProfilePicBar(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 30.dp, bottom = 25.dp)
                .height(56.dp)
        ) {
            Row(Modifier.fillMaxSize(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                RoundedSquarePic(painter = painterResource(id = R.drawable.jeet))
                NotificationIcon()
            }
        }
    }

    @Composable
    fun RoundedSquarePic(painter: Painter,modifier: Modifier = Modifier) {
        Image(
            contentScale = ContentScale.Crop,
            painter = painter,
            contentDescription = null,

            modifier = modifier
                .size(36.dp)
                .border(
                    width = 1.dp, brush = Brush.linearGradient(
                        listOf(
                            Color.Blue,
                            Color.Green,
                            Color.Cyan,
                            Color.Magenta
                        )
                    ), shape = RoundedCornerShape(7.dp)
                )
                .padding(3.dp)
                .clip(RoundedCornerShape(7.dp),
                )


        )
    }

    @Composable
    fun NotificationIcon(modifier: Modifier = Modifier) {
        Icon(
            Icons.Outlined.Notifications,
            tint = Color.White,
            contentDescription = null,
            modifier = modifier
                .size(30.dp)

                .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(5.dp)

        )
    }

    @Composable
    fun GreetingText(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Good Morning $name,",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp,
            modifier = modifier
        )
    }


    @Composable
    fun DebitCard(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(.4f)
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color.Blue,
                            Color.Green,
                            Color.Cyan,
                            Color.Magenta
                        ), tileMode = TileMode.Clamp
                    )
                )

        ) {

            CardNameIcon()
            Column(
                Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)
            ) {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2f)
                        .padding(start = 10.dp, end = 10.dp),
                    Arrangement.SpaceBetween, Alignment.CenterVertically
                ) {

                    CardNumber(
                        modifier = Modifier
                    )
                    CardNumber(
                        modifier = Modifier
                    )
                    CardNumber(
                        modifier = Modifier
                    )
                    CardNumber(
                        modifier = Modifier
                    )


                    Text(text = "23/24", color = Color.White, fontSize = 15.sp)

                }
                CardExpiryDate(modifier = Modifier.fillMaxHeight(0.1f))
            }

        }
    }

    @Composable
    fun CardNameIcon(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth()

                .padding(start = 20.dp, end = 20.dp, top = 10.dp), Arrangement.SpaceBetween
        ) {
            Text(text = "VISA", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

            Icon(
                painter = painterResource(id = R.drawable.creditcard),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
        }
    }

    @Composable
    fun CardNumber(modifier: Modifier = Modifier) {
        Row(modifier = modifier, Arrangement.SpaceEvenly) {


            Canvas(
                modifier = Modifier.aspectRatio(0.2f, matchHeightConstraintsFirst = true),
                onDraw = {
                    drawCircle(color = Color.White)
                })
            Spacer(modifier = Modifier.width(3.dp))
            Canvas(
                modifier = Modifier.aspectRatio(0.2f, matchHeightConstraintsFirst = true),
                onDraw = {
                    drawCircle(color = Color.White)
                })
            Spacer(modifier = Modifier.width(3.dp))

            Canvas(
                modifier = Modifier.aspectRatio(0.2f, matchHeightConstraintsFirst = true),
                onDraw = {
                    drawCircle(color = Color.White)
                })
            Spacer(modifier = Modifier.width(3.dp))

            Canvas(
                modifier = Modifier.aspectRatio(0.2f, matchHeightConstraintsFirst = true),
                onDraw = {
                    drawCircle(color = Color.White)
                })


        }


    }

    @Composable
    fun CardExpiryDate(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            Arrangement.SpaceBetween
        ) {
            Text(text = "People can fly", color = Color.LightGray, fontSize = 10.sp)

            Text(text = "2023", color = Color.LightGray, fontSize = 10.sp)
        }
    }

    @Composable
    fun AddNewCardButton(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .background(Color(62, 56, 63, 255)),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                Modifier.padding(start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Filled.AccountBox,
                    contentDescription = null,
                    Modifier.aspectRatio(0.5f, matchHeightConstraintsFirst = true),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Add a new credit card", color = Color.White, fontSize = 15.sp)
            }

            Icon(
                Icons.Filled.Add,
                contentDescription = null,
                Modifier
                    .padding(end = 20.dp)
                    .aspectRatio(0.5f, matchHeightConstraintsFirst = true)

                    .align(
                        Alignment.CenterEnd
                    ),
                tint = Color.White
            )
        }
    }

    @Composable
    fun Menu(
        modifier: Modifier = Modifier,
        menuList: List<MenuItemsString>,
        activeTextColor: Color = Color.White,
        inactiveTextColor: Color = Color.DarkGray,
        initialSelectedItem: Int = 0
    ) {
        Row(modifier = modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            var selectedItemIndex by remember {
                mutableStateOf(0)
            }

            menuList.forEachIndexed { index, items ->
                MenuItem(
                    menuName = items.item,
                    isSelected = (index == selectedItemIndex)
                ) {
                    selectedItemIndex = index
                }
            }
        }
    }

    @Composable
    fun MenuItem(
        menuName: String, activeTextColor: Color = Color.White,
        inactiveTextColor: Color = Color.DarkGray,
        initialSelectedItem: Int = 0,
        isSelected: Boolean = false,
        onItemClick: () -> Unit
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                onItemClick()
            }) {
            if (isSelected) {

                Text(
                    text = menuName,
                    color = activeTextColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(3.dp))

                Canvas(
                    modifier = Modifier.size(8.dp),
                    onDraw = {
                        drawCircle(color = Color.Red)
                    })

            } else {
                Text(
                    text = menuName,
                    color = inactiveTextColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }

    }

    @Composable
    fun Chart(modifier: Modifier = Modifier) {
        Box(modifier =modifier
            .background(Color(62, 56, 63, 255))
            .height(500.dp)
            .fillMaxWidth()) {
            Column(
                modifier = modifier.
                    fillMaxWidth()
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp), Arrangement.SpaceBetween
                ) {
                    Text(text = "your earnings", color = Color.White, fontSize = 17.sp)
                    Text(text = "pending clearance", color = Color.DarkGray, fontSize = 15.sp)
                }
            }
        }
    }
}

data class MenuItemsString(
    var item: String
)