package com.ismoyb.pruebatecnica.ui.adapters.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ismoyb.pruebatecnica.ui.adapters.BooksAdapter

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: T, position: Int, holder: BooksAdapter.BindViewHolder)
}