package com.workdev.bigrewards.ui.Main
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.workdev.bigrewards.Adapters.AdapterPosts
import com.workdev.bigrewards.OnClick
import com.workdev.bigrewards.R
import com.workdev.bigrewards.SealedClass.ApiState
import com.workdev.bigrewards.databinding.ActivityMainBinding
import com.workdev.bigrewards.ui.Body.body
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , OnClick {

    lateinit var binding: ActivityMainBinding
    private val  viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.Posts()

        var adapter=AdapterPosts(this)
        binding.rec.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        binding.rec.adapter =adapter

    viewModel.PostsLive.observe(this){
        when (it) {
            is ApiState.Loading -> {

            }
            is ApiState.Failure -> {

                Toast.makeText(this,""+it.apiError, Toast.LENGTH_LONG).show()
            }
            is ApiState.Success -> {

                adapter.differ.submitList(it.data)

            }
            is ApiState.Empty -> {

            }
            else -> {

            }
        }


    }



























    }

    override fun getId(Id: Int) {
       val intent=Intent(this,body::class.java)
        intent.putExtra("id",Id)
        startActivity(intent)
    }


}