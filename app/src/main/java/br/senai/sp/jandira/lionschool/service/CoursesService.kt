package br.senai.sp.jandira.lionschool.service

import android.telecom.Call
import br.senai.sp.jandira.lionschool.model.CoursesList
import retrofit2.http.GET

interface CoursesService {

    //https://api-school-n6sg.onrender.com/v1/lion-school/cursos

    //https://api-school-n6sg.onrender.com/v1/lion-school/alunos/curso?sigla=${siglaCurso}

    //https://api-school-n6sg.onrender.com/v1/lion-school/matricula?matricula=${matricula}

    @GET("course")
    fun getCourses(): Call<CoursesList>

}