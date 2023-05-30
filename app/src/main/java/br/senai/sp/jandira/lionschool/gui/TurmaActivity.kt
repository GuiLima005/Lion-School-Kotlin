package br.senai.sp.jandira.lionschool.gui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.model.CoursesList
import br.senai.sp.jandira.lionschool.model.Student
import br.senai.sp.jandira.lionschool.model.StudentList
import br.senai.sp.jandira.lionschool.service.RetrofitFactory
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TurmaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {

    val context = LocalContext.current

    var alunos by remember {
        mutableStateOf(listOf<Student>())
    }


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
                    val intent = Intent(context, MainActivity::class.java)
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
                text = "Turma",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Image(
                painter = painterResource(id = R.drawable.logo_image), contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {

            Text(
                text = "Desenvolvimento de Sistemas",
                fontSize = 42.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Card(
                modifier = Modifier
                    .height(25.dp)
                    .width(85.dp),
                shape = CircleShape
            ) {
                Text(
                    text = "Todos",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            Card(
                modifier = Modifier
                    .height(25.dp)
                    .width(85.dp),
                shape = CircleShape
            ) {
                Text(
                    text = "Cursando",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            Card(
                modifier = Modifier
                    .height(25.dp)
                    .width(85.dp),
                shape = CircleShape
            ) {
                Text(
                    text = "Finalizados",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

        }

        Spacer(modifier = Modifier.height(55.dp))

        val call = RetrofitFactory().getCourseService().getAlunosCursos("DS")

        call.enqueue(object : Callback<StudentList> {
            override fun onResponse(
                call: Call<StudentList>, response: Response<StudentList>
            ) {
                alunos = response.body()!!.alunos
            }

            override fun onFailure(call: Call<StudentList>, t: Throwable) {
                Log.i("Alunos", "onFailure: ${t.message}")
            }

        })
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(horizontal = 35.dp)
                .clickable {
                    val intent = Intent(context, AlunoActivity::class.java)
                    context.startActivity(intent)
                },
            shape = RoundedCornerShape(
                topStart = 30.dp,
                topEnd = 30.dp,
                bottomStart = 30.dp,
                bottomEnd = 30.dp
            ),
            backgroundColor = Color.White,
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    shape = CircleShape

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.aluno),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)

                    )
                }

                LazyColumn() {
                    items(alunos) {

                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(vertical = 20.dp, horizontal = 20.dp),
                            verticalArrangement = Arrangement.SpaceBetween,

                            ) {

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = it.nome,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                textAlign = TextAlign.Center

                            )

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = it.status,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )


                        }
                        
                    }
                    
                }
            }
        }


    }
}

private fun <T> Call<T>.enqueue(callback: Callback<StudentList>) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    LionSchoolTheme {
        Greeting2("Android")
    }
}