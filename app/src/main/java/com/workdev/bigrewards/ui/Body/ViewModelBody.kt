package com.workdev.bigrewards.ui.Body

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.workdev.bigrewards.Repository.MainRepository
import com.workdev.bigrewards.SealedClass.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel

class ViewModelBody  @Inject constructor(private val mainRepository: MainRepository): ViewModel() {


    private var BodyPosts: MutableLiveData<ApiState> = MutableLiveData<ApiState>(ApiState.Empty)

    val BodyPostsLive: LiveData<ApiState> = BodyPosts


    fun BodyPosts(id:Int) {
        viewModelScope.launch {
            BodyPosts.value = ApiState.Loading
            mainRepository.BodyPost(id)
                .catch { e ->
                    BodyPosts.value = ApiState.Failure(e)
                }.collect { data ->
                    BodyPosts.value = ApiState.Success(data)

                }
        }


    }
}