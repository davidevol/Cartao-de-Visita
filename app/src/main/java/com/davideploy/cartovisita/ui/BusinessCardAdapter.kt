package com.davideploy.cartovisita.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.davideploy.cartovisita.data.BusinessCard
import com.davideploy.cartovisita.databinding.ItemBussinesCardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    inner class ViewHolder(
        private val binding: ItemBussinesCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BusinessCard) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener{
                listenerShare(it)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBussinesCardBinding.inflate(inflater, parent, false )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newitem: BusinessCard) = oldItem == newitem
    override fun areContentsTheSame(oldItem: BusinessCard, newitem: BusinessCard) =
        oldItem.id == newitem.id
}