package com.workdev.bigrewards.ui.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.workdev.bigrewards.Repository.MainRepository
import com.workdev.bigrewards.SealedClass.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject
@HiltViewModel
class ViewModel  @Inject constructor(private val mainRepository: MainRepository): ViewModel(){



    private var Posts: MutableLiveData<ApiState> = MutableLiveData<ApiState>(ApiState.Empty)

    val PostsLive: LiveData<ApiState> = Posts



    fun Posts(){
        viewModelScope.launch {
            Posts.value = ApiState.Loading
            mainRepository.Posts()
                .catch { e->
                    Posts.value = ApiState.Failure(e)
                }.collect{data ->
                    Posts.value = ApiState.Success(data)

                }
        }


    }
}



