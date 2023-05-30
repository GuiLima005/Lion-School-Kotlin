package br.senai.sp.jandira.lionschool.gui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.gui.ui.theme.LionSchoolTheme

class AlunoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(51, 71, 176))

    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = {
                    val intent = Intent(context, TurmaActivity::class.java)
                    context.startActivity(intent)
                }, 
                colors = ButtonDefaults.buttonColors(Color(51, 71, 176))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.voltar),
                    contentDescription = null
                )
            }

            Text(
                text = "Notas",
                fontSize = 35.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )

            Image(
                painter = painterResource(id = R.drawable.logo_image), contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(30.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                shape = CircleShape,
                backgroundColor = Color(51, 71, 176),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.aluno),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)

                )
            }

            Text(
                modifier = Modifier.padding(vertical = 25.dp),
                text = "José Matheus da Silva Miranda",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            backgroundColor = Color.White
        ) {

        }



    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    LionSchoolTheme {
        Greeting3("Android")
    }
}