package rs.myexample.hilt.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil

abstract class BasePagingDataAdapter<ItemT : Any>(diffCallback: DiffUtil.ItemCallback<ItemT>) :
    PagingDataAdapter<ItemT, BaseViewHolder>(diffCallback) {

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
        provideViewModel(position)?.let {
            holder.bindViewModel(it)
        }
    }

    override fun getItemViewType(position: Int): Int = provideLayoutId(position)

    @LayoutRes
    abstract fun provideLayoutId(position: Int): Int

    abstract fun provideViewModel(position: Int): ViewModel?
}