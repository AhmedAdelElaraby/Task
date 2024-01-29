package com.workdev.bigrewards.SealedClass


import com.workdev.bigrewards.ResponseDataClass.ModelPosts


sealed class ApiState {
    object Loading : ApiState()
    class  Success(val data: List<ModelPosts>) : ApiState()
     class Failure (val apiError: Throwable) : ApiState()
   object Empty : ApiState()

}
