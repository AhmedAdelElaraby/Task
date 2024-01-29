package com.workdev.bigrewards.ui.Body

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.workdev.bigrewards.R
import com.workdev.bigrewards.SealedClass.ApiState
import com.workdev.bigrewards.databinding.ActivityBodyBinding
import com.workdev.bigrewards.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class body : AppCompatActivity() {
    lateinit var binding: ActivityBodyBinding
    private val viewmodel:ViewModelBody by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_body)
        val id=intent.getIntExtra("id",0)
        viewmodel.BodyPosts(id)


        viewmodel.BodyPostsLive.observe(this){
            when (it) {
                is ApiState.Loading -> {

                }
                is ApiState.Failure -> {

                    Toast.makeText(this,""+it.apiError, Toast.LENGTH_LONG).show()
                }
                is ApiState.Success -> {

                    binding.text.text=it.data[0].body

                }
                is ApiState.Empty -> {

                }
                else -> {

                }
            }


        }




    }
}