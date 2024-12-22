package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

val md_theme_light_tertiary = Color(0xFF51643F)
val md_theme_light_onTertiary = Color(0xFF243515)
val md_theme_light_tertiaryContainer = Color(0xFFD4EABB)
val md_theme_light_onTertiaryContainer = Color(0xFF102004)


val md_theme_light_primary = Color(0xFF825500)
val md_theme_light_onPrimary = Color(0xFF452B00)
val md_theme_light_primaryContainer = Color(0xFFFFDDB3)
val md_theme_light_onPrimaryContainer = Color(0xFF291800)


@Composable
fun FirstScreen(navigationToSecondScreen: () -> Unit) {
    var text_input1 by remember { mutableStateOf("Lorem Ipsum 1") }

    val mdf = Modifier
        .padding(10.dp)
        .fillMaxHeight()
        .background(md_theme_light_onTertiaryContainer)

    // val name = remember { mutableStateOf("") }

    Column(modifier = mdf, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(50.dp))

        Card(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(10.dp)),
            colors = (CardDefaults.cardColors(
                containerColor = md_theme_light_tertiary,
                contentColor = md_theme_light_tertiaryContainer
            ))
        ) {
            Text(
                text = "1",
                textAlign = TextAlign.Center,
                modifier = Modifier.width(100.dp),
                fontSize = 80.sp
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Box(modifier = Modifier.wrapContentSize()) {
            Text(text = "First Screen")
        }
        Box(modifier = Modifier.wrapContentWidth()) {
            OutlinedTextField(value = text_input1, onValueChange = { text_input1 = it })
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Card(
            modifier = Modifier
                .width(500.dp)
                .height(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = md_theme_light_onTertiary
            )
        ) {
            Row {//main row
                Box(modifier = Modifier.width(120.dp)) {
                    Card(
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp),
                        shape = CircleShape
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gamer1),
                            contentDescription = "null"
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp)
                ) {
                    Column {


                        Spacer(modifier = Modifier.height(6.dp))
                        Row {
                            Icon(imageVector = Icons.Rounded.Info, contentDescription = "ggwp")
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = text_input1, fontWeight = FontWeight.Bold)
                        }
                        Text(
                            text = "Lorem ipsum odor amet, consectetuer adipiscing elit.\n" +
                                    "\n",
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Box(modifier = Modifier.wrapContentWidth()) {
            Button(onClick = { navigationToSecondScreen() }) {
                Text(text = "To the 2nd Screen!")
            }
        }
    }
}


@Composable
fun SecondScreen(navigationToFirstScreen: () -> Unit) {

    var text_input2 by remember { mutableStateOf("Lorem Ipsum 2") }
    val mdf = Modifier
        .padding(10.dp)
        .fillMaxHeight()
        .background(color = md_theme_light_onPrimaryContainer)

    // val name = remember { mutableStateOf("") }

    Column(modifier = mdf, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(50.dp))

        Card(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(10.dp)), colors = CardDefaults.cardColors(
                containerColor = md_theme_light_primary,
                contentColor = md_theme_light_primaryContainer
            )
        ) {
            Text(
                text = "2",
                textAlign = TextAlign.Center,
                modifier = Modifier.width(100.dp),
                fontSize = 80.sp
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Box(modifier = Modifier.wrapContentSize()) {
            Text(text = "Second Screen")
        }
        Box(modifier = Modifier.wrapContentWidth()) {
            OutlinedTextField(value = text_input2, onValueChange = { text_input2 = it })
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Card(
            modifier = Modifier
                .width(500.dp)
                .height(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = md_theme_light_onPrimary
            )

        ) {
            Row {//main row
                Box(modifier = Modifier.width(120.dp)) {
                    Card(
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp),
                        shape = CircleShape
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gamer7),
                            contentDescription = "null"
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp)
                ) {
                    Column {


                        Spacer(modifier = Modifier.height(6.dp))
                        Row {
                            Icon(imageVector = Icons.Rounded.Info, contentDescription = "ggwp")
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = text_input2, fontWeight = FontWeight.Bold)
                        }
                        Text(
                            text = "Lorem ipsum odor amet, consectetuer adipiscing elit.\n" +
                                    "\n",
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Box(modifier = Modifier.wrapContentWidth()) {
            Button(onClick = { navigationToFirstScreen() }) {
                Text(text = "To the 2nd Screen!")
            }
        }
    }
}


@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen({})
}


@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen({})
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen") {
        composable("firstscreen") {
            FirstScreen {
                navController.navigate("secondscreen")
            }
        }
        composable("secondscreen") {
            SecondScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}