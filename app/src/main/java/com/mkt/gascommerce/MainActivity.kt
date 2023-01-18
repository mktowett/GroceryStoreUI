package com.mkt.gascommerce

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mkt.gascommerce.ui.theme.GasCommerceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun MainTheme(content: @Composable () -> Unit) {
    GasCommerceTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GasCommerceTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {

        //background image
        Image(
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header Background",
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            contentScale = ContentScale.FillWidth
        )

        Scaffold(
            topBar = { AppBar() },
            backgroundColor = Color.Transparent
        ) {
            Content(paddingValues = it)
        }
    }
}

//toolbar
@Composable
fun AppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(16.dp)
            .height(48.dp)

    ) {
        //search bar
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Search Food, Veg", fontSize = 12.sp) },
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search button")
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Spacer(
            modifier = Modifier
                .width(8.dp)
        )

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "",
                tint = Color.White
            )
        }
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "",
                tint = Color.White
            )
        }

    }
}

@Composable
fun Content(paddingValues: PaddingValues) {
    Column(Modifier.padding(paddingValues)) {
        Header()
        Spacer(modifier = Modifier.height(20.dp))
        Promotions()
        Spacer(modifier = Modifier.height(20.dp))
        CategorySection()

    }
}

@Composable
fun Header() {
    Card(
        Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            QrButton()
            VerticalDivider()
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_money),
                    contentDescription = "Money Icon",
                    tint = Color(0xFF6FCF97)
                )
                Column(Modifier.padding(horizontal = 8.dp)) {
                    Text(
                        text = "KES 120,000.00",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Top-up",
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.primary
                    )
                }
            }
            VerticalDivider()
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin),
                    contentDescription = "Money Icon",
                    tint = MaterialTheme.colors.primary
                )
                Column(Modifier.padding(horizontal = 8.dp)) {
                    Text(
                        text = "KES 20,000.00",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Points",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun QrButton() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = "Scan Button"
        )
    }
}

@Composable
fun VerticalDivider() {
    Divider(
        color = Color(0xFFF1F1F1),
        modifier = Modifier
            .width(1.dp)
            .height(32.dp)
    )
}

@Composable
fun Promotions() {
    LazyRow(
        modifier = Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PromotionItems(
                title = "Fruits",
                subtitle = "Priced To Go",
                header = "KES 50",
                imagePainter = painterResource(id = R.drawable.promotion),
                backgroundColor = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            PromotionItems(
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
                imagePainter = painterResource(id = R.drawable.promotion),
                backgroundColor = Color(0xFF6EB6F5)
            )
        }
    }
}

@Composable
fun PromotionItems(
    title: String,
    subtitle: String,
    header: String,
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    color = Color.White
                )

                Text(
                    text = subtitle,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = header,
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                painter = imagePainter,
                contentDescription = "Promotion image",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun CategorySection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Categories", style = MaterialTheme.typography.h6)
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryButton(
                text = "Fruits",
                icon = painterResource(id = R.drawable.ic_orange),
                backgroundColor = Color(0xFFFEF4E7)
            )

            CategoryButton(
                text = "Vegetables",
                icon = painterResource(id = R.drawable.ic_veg),
                backgroundColor = Color(0xFFF6FBF3)
            )

            CategoryButton(
                text = "Dairy",
                icon = painterResource(id = R.drawable.ic_cheese),
                backgroundColor = Color(0xFFFFFBF3)
            )

            CategoryButton(
                text = "Meat",
                icon = painterResource(id = R.drawable.ic_meat),
                backgroundColor = Color(0xFFF6E6E9)
            )
        }
    }
}

@Composable
fun CategoryButton(
    text: String ,
    icon: Painter,
    backgroundColor: Color
) {
    Column(modifier = Modifier
        .width(64.dp)
        .clickable { }
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(18.dp)
        ) {
            Icon(painter = icon, contentDescription = "category icon")
        }
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}
