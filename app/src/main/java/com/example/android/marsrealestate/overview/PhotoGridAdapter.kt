package com.example.android.marsrealestate.overview

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsrealestate.databinding.GridViewItemBinding
import com.example.android.marsrealestate.network.MarsProperty

class PhotoGridAdapter : ListAdapter<MarsProperty, PhotoGridAdapter.MarsProperyViewHolder>(DiffCallback){
    class MarsProperyViewHolder(private  var binding: GridViewItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: MarsProperty){
            binding.property  = marsProperty
            binding.executePendingBindings()
        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsProperty>() {
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return  oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.MarsProperyViewHolder {
        return MarsProperyViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.MarsProperyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
    }

}