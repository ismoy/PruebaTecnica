package com.ismoyb.pruebatecnica.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.ismoyb.pruebatecnica.R
import com.ismoyb.pruebatecnica.data.OnItemClickListener
import com.ismoyb.pruebatecnica.databinding.ItemBooksBinding
import com.ismoyb.pruebatecnica.domain.model.Item
import com.ismoyb.pruebatecnica.ui.adapters.viewHolder.BaseViewHolder

class BooksAdapter(private val itemClickListener: OnItemClickListener):ListAdapter<Item,BaseViewHolder<*>>(DiffUtilCallback) {
    private object DiffUtilCallback:DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemBooksBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BindViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is BindViewHolder ->holder.bind(getItem(position),position,holder)
        }
    }
    inner class BindViewHolder(private val binding: ItemBooksBinding):BaseViewHolder<Item>(binding.root) {
        override fun bind(item: Item, position: Int, holder: BindViewHolder) {
            renderInfo(binding,item,holder)

        }

    }

    private fun renderInfo(binding: ItemBooksBinding, item: Item, holder: BindViewHolder) {
        holder.itemView.setOnClickListener (onClickItemListener(item))
      with(binding){
          Glide.with(imageBooks.context)
              .load(item.volumeInfo?.imageLinks?.smallThumbnail)
              .placeholder(R.drawable.default_image)
              .error(R.drawable.default_image)
              .into(imageBooks)

          titleBooks.text= item.volumeInfo.title
          descriptionBooks.text = item.volumeInfo.description
      }
    }

    private fun onClickItemListener(item: Item): View.OnClickListener? {
        return View.OnClickListener {
            item.volumeInfo?.imageLinks?.thumbnail?.let { it1 -> itemClickListener.onItemClicked(it1) }
        }
    }
}


