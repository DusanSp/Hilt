package rs.myexample.hilt.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseDiffAdapter<ItemT>(diffCallback: DiffUtil.ItemCallback<ItemT>) :
    ListAdapter<ItemT, BaseViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindViewModel(provideViewModel(position))
    }

    override fun getItemViewType(position: Int): Int = provideLayoutId(position)

    @LayoutRes
    abstract fun provideLayoutId(position: Int): Int

    abstract fun provideViewModel(position: Int): ViewModel
}