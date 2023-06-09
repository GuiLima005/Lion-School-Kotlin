package br.senai.sp.jandira.lionschool.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL_BASE = "https://api-school-n6sg.onrender.com/v1/lion-school/"

    private val retrofitFactory = Retrofit.Builder().baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCourseService(): CoursesService {
        return  retrofitFactory.create(CoursesService::class.java)
    }

    fun getAlunosService(): StudentService{
        return retrofitFactory.create(StudentService::class.java)
    }

}