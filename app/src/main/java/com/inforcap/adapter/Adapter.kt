package com.inforcap.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.inforcap.R
import com.inforcap.data.Data
import com.inforcap.databinding.ItemStoreBinding


class Adapter (
    private val storeList: List<Data>, var onClick: (Data) -> Unit) : RecyclerView.Adapter<Adapter.StoreViewHolder>() {

    lateinit var binding: ItemStoreBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        binding = ItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreViewHolder(binding)
    }

    override fun getItemCount(): Int = storeList.size

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val item = storeList[position]
        holder.onBind(item,onClick)
    }

    inner class StoreViewHolder(private val binding: ItemStoreBinding) : ViewHolder(binding.root){
        fun onBind(store: Data,onClick: (Data) -> Unit){
            with(binding) {
                store.run {
                    textView1.text = store.name
                    horarioAtencion.text= store.officeHours
                    Glide.with(imageStore.context)
                        .load(store.photo)
                        .centerCrop()
                        .error(R.drawable.baseline_error_outline_24)
                        .into(binding.imageStore)
                }

            }

            binding.constrait2.setOnClickListener {
                onClick?.invoke(store)
            }
        }
    }
}