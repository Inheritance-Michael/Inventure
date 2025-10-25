package com.example.inventure


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



val ingredientBackground = Brush.linearGradient(
    colors = listOf(
        Color(0xFFDCE775), // Light Green (like soft lime)
        Color(0x80A5A5A5)  // Light Gray
    ),
    start = Offset(0f, 0f),
    end = Offset(1000f, 1000f)
)


@Composable
fun HomePage(modifier: Modifier = Modifier,  ){

    var valueChange by remember { mutableStateOf("") }

    Column( modifier = modifier.background(brush = ingredientBackground)) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp)

        ) {
            Row(modifier = modifier.fillMaxWidth()) {
                Box(
                    modifier = modifier
                        .clip(RoundedCornerShape(50.dp))
                        .size(50.dp)
                        .background(Color(0xFF4CAF50)),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        "IN",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable{}
                ){
                    Box(
                        modifier = modifier
                            .clip(RoundedCornerShape(20.dp))
                            .size(50.dp)
                            .background(Color(0xFFFFFFFF))
                            .clickable{},
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(R.drawable.notification),
                            "notification ball icon",
                            modifier = modifier
                                .size(30.dp)
                        )
                    }
                    Spacer(modifier = modifier.width(10.dp))
                    Box(
                        modifier = modifier
                            .clip(RoundedCornerShape(20.dp))
                            .size(50.dp)
                            .background(Color(0xFFFFFFFF))
                            .clickable{},
                        contentAlignment = Alignment.Center,

                    ){
                        Image(
                            painter = painterResource(R.drawable.add),
                            "notification ball icon",
                            modifier = modifier
                                .size(30.dp)
                        )
                    }
                }

            }

            Spacer( modifier = modifier.height(10.dp))

            Row(modifier = modifier.fillMaxWidth()) {
                TextField(
                    value = valueChange,
                    onValueChange = {},
                    label = {


                        Row {
                            Icon(
                                painter = painterResource(R.drawable.search),
                                "Search icon",
                                modifier = modifier
                                    .size(30.dp)
                            )
                            Spacer(modifier = modifier.width(10.dp))
                            Text(
                                "Search",
                                fontSize = 20.sp
                            )
                        }

                    },
                    modifier = modifier
                        .clip(RoundedCornerShape(50.dp))
                        .width(310.dp)
                        .height(50.dp)
                )
                 Spacer(modifier = modifier.width(10.dp))

                Box(
                    modifier = modifier
                        .clip(RoundedCornerShape(20.dp))
                        .size(50.dp)
                        .background(Color(0xFFFFFFFF)),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.topcategorize),
                        "notification ball icon",
                        modifier = modifier
                            .size(30.dp)
                    )
                    //box content
                }
            }

            Spacer(modifier = modifier.height(10.dp))

            Column(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                LazyActivity()
            }

            Spacer(modifier = modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "Activity",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "More",
                    )
                }
            }

            Spacer(modifier = modifier.height(10.dp))
            Column(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = modifier
                        .clip(RoundedCornerShape(20.dp))
                        .width(350.dp)
                        .height(150.dp)
                        .background(Color(0xFFFFFFFF))
                        .clickable{},
                    contentAlignment = Alignment.CenterStart,
                ){
//                    Image(
//                        painter = painterResource(R.drawable.portrait_lesbian),
//                        ""
//                    )
                }
            }

            Spacer(modifier = modifier.height(10.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                LazyItem()
            }

            Spacer(modifier = modifier.height(10.dp))

            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                LazyItemTwo()
            }

            Spacer(modifier = modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "Most Popular",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "See All",
                    )
                }
            }

            Row {
                
            }
            //column
        }
    }
}

@Composable
fun LazyActivity(){
    val images = listOf(
        R.drawable.outofstock,
        R.drawable.stocksgrowth,
        R.drawable.sellstock
    )

    val count = listOf(
        "60",
        "360",
        "1,404"
    )

    val name = listOf(
        "Out of Stock",
        "Low Stock",
        "Total stock"
    )

    LazyRow(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        items(images.size){
                index -> ActivityBox(
            images[index], count[index], name[index]
        )
        }
    }

}

@Composable
fun ActivityBox(image: Int, count: String, name: String, modifier: Modifier = Modifier){

    Box(
        modifier = modifier
            .shadow(
                elevation = 8.dp,      // how big the shadow appears
                shape = RoundedCornerShape(20.dp), // optional, for rounded corners
                clip = false           // if true, the shadow won’t show outside the shape
            )
            .height(110.dp)
            .width(110.dp)
            .background(Color(0xFFFFFFFF), RoundedCornerShape(20.dp))
            .padding(10.dp)
            .clickable{}
            ,
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = modifier
                    .size(50.dp)
                    .background(Color(0x90A5A5A5), RoundedCornerShape(20.dp))
                    .clickable{},
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(image),
                    ""
                )
            }
            Spacer(modifier = modifier.height(3.dp))
            Text(
                count,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                name,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }

}

@Composable
fun LazyItem(){
    val item = listOf(
        Triple(R.drawable.sofa, Color(0x7AAE5DA3), "sofa"),
        Triple(R.drawable.chair, Color(0x7A9C620F), "chair"),
        Triple(R.drawable.lamptwo, Color(0x7A61B0B2), "lamp"),
        Triple(R.drawable.lamp, Color(0x7ACA411C), "light"),

    )


    LazyRow(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        items(item.size){
                index ->
            val (imageRes, color, title) = item[index]
            MenuBox(
            imageRes,
                color,
                title
        )
        }
    }
}

@Composable
fun MenuBox(image: Int, color: Color, title: String, modifier: Modifier = Modifier){

    Column(
        modifier =modifier
            .fillMaxWidth(),
       horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .size(60.dp)
                .background(color, RoundedCornerShape(50.dp))
                .clickable{},
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(image),
                ""
            )
        }
        Spacer(modifier = modifier.height(5.dp))
        Text(
            title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

///
@Composable
fun LazyItemTwo(){
    val item = listOf(
        Triple(R.drawable.vase, Color(0x7A27282B), "vase"),
        Triple(R.drawable.kitchen, Color(0x4D4F0401), "kitchen"),
        Triple(R.drawable.cupboard, Color(0x7A343C85), "board"),
        Triple(R.drawable.apps, Color(0x7C4CAF50), "more")
    )


    LazyRow(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        items(item.size){
                index ->
            val (imageRes, color, title) = item[index]
            MenuBoxTwo(
                imageRes,
                color,
                title
            )
        }
    }
}

@Composable
fun MenuBoxTwo(image: Int, color: Color, title: String, modifier: Modifier = Modifier){

    Column(
        modifier =modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .size(60.dp)
                .background(color, RoundedCornerShape(50.dp))
                .clickable{},
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(image),
                ""
            )
        }
        Spacer(modifier = modifier.height(5.dp))
        Text(
            title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowUI(){
    HomePage()
    //LazyActivity()
    //LazyItem()
}