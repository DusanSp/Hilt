package rs.myexample.hilt.utils

import androidx.databinding.BindingAdapter
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import rs.myexample.hilt.presentation.main.adapter.BaseDiffAdapter
import rs.myexample.hilt.presentation.main.adapter.BasePagingDataAdapter

@BindingAdapter(value = ["items"])
fun <ItemT> RecyclerView.setItems(items: List<ItemT>?) {
    val adapter = this.adapter
    @Suppress("UNCHECKED_CAST")
    (adapter as? BaseDiffAdapter<ItemT>)?.submitList(items ?: emptyList())
}