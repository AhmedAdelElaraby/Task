package com.workdev.bigrewards.Network


import com.workdev.bigrewards.ResponseDataClass.ModelPosts
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("posts")
    suspend fun posts(): List<ModelPosts>

    @GET("posts")
    suspend fun BodyPost( @Query("id") id: Int,
    ):List<ModelPosts>


}