package br.senai.sp.jandira.lionschool.service

import br.senai.sp.jandira.lionschool.model.CoursesList
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface CoursesService {

    //https://api-school-n6sg.onrender.com/v1/lion-school/cursos

    //https://api-school-n6sg.onrender.com/v1/lion-school/alunos/curso?sigla=${siglaCurso}

    //https://api-school-n6sg.onrender.com/v1/lion-school/matricula?matricula=${matricula}

    //https://api-school-n6sg.onrender.com/v1/lion-school/


    @GET("cursos")
    fun getCourses(): Call<CoursesList>

    @GET("alunos/curso?sigla={sigla}")
    fun getAlunosCursos(@Query("sigla") sigla:String): Call<br.senai.sp.jandira.lionschool.model.Student>


//    @GET("matricula?matricula={matricula}")
//    fun GetNotaAluno(@Path("matricula") sigla:String): Call<br.senai.sp.jandira.lionschool.model.Registration>

}