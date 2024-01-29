package com.workdev.bigrewards.Repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException

//fun convertErrorBody(throwable: HttpException):ErrorResponse?{
//
//    return try {
//        val error=throwable.response()?.errorBody()?.charStream()
//        val gson=Gson()
//        val type = object : TypeToken<ErrorResponse>() {}.type
//        var errorResponse:ErrorResponse? =gson.fromJson(error,type)
//        errorResponse
//    } catch (exception :Exception){
//
//        null
//    }

//}