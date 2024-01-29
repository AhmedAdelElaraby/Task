package com.workdev.bigrewards.Repository

import com.workdev.bigrewards.Network.ApiServiceImpl
import com.workdev.bigrewards.ResponseDataClass.ModelPosts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class MainRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun Posts(): Flow<List<ModelPosts>> = flow {
        emit(apiServiceImpl.Posts())
    }.flowOn(Dispatchers.IO)


    fun BodyPost(id:Int): Flow<List<ModelPosts>> =
        flow {
            emit(apiServiceImpl.BodyPost(id))
        }.flowOn(Dispatchers.IO)



}