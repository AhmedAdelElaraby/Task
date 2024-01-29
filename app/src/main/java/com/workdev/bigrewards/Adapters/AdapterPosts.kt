package com.workdev.bigrewards.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workdev.bigrewards.OnClick
import com.workdev.bigrewards.ResponseDataClass.ModelPosts
import com.workdev.bigrewards.databinding.ItemBinding


internal class AdapterPosts (onClick: OnClick): RecyclerView.Adapter<AdapterPosts.ViewHolder>(){
    private lateinit var binding: ItemBinding
    private  var onclick:OnClick

    init {
        this.onclick=onClick
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterPosts.ViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)



    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    override fun onBindViewHolder(holder: AdapterPosts.ViewHolder, position: Int) {
        binding.text.text = differ.currentList[position].title

        holder.setIsRecyclable(false)
        holder.itemView.setOnClickListener {
            onclick.getId(differ.currentList[position].id)
        }

    }
    inner class ViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<ModelPosts>(){
        override fun areItemsTheSame(oldItem: ModelPosts, newItem: ModelPosts): Boolean {
            return  oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: ModelPosts, newItem: ModelPosts): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallback)
}