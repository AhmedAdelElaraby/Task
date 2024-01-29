package com.workdev.bigrewards.Network



import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val api: API) {

    suspend fun Posts() = api.posts()

    suspend fun BodyPost(id: Int) = api.BodyPost(id)


}