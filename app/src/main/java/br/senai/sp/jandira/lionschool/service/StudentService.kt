package br.senai.sp.jandira.lionschool.service

import br.senai.sp.jandira.lionschool.model.ListDisciplinas
import br.senai.sp.jandira.lionschool.model.Student
import br.senai.sp.jandira.lionschool.model.StudentList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StudentService {

    //https://api-school-n6sg.onrender.com/v1/lion-school/cursos

    //https://api-school-n6sg.onrender.com/v1/lion-school/alunos/curso?sigla=${siglaCurso}

    //https://api-school-n6sg.onrender.com/v1/lion-school/matricula?matricula=${matricula}

    //URL BASE
    //https://api-school-n6sg.onrender.com/v1/lion-school/

    @GET("alunos")
    fun getAlunos():Call<StudentList>

    @GET("alunos")
    fun getStatus(@Query("status") status: String): Call<StudentList>


    @GET("alunos/curso/")
    fun getCurso(@Query("sigla") curso: String):Call<StudentList>

    @GET("matricula/")
    fun getMatricula(@Query("matricula") matricula: String):Call<ListDisciplinas>

}