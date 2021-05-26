package rs.myexample.hilt.presentation.main.list

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import rs.myexample.hilt.R
import rs.myexample.hilt.presentation.main.adapter.BasePagingDataAdapter
import javax.inject.Inject

class PostsAdapter
@Inject constructor() : BasePagingDataAdapter<UserItemView>(CALLBACK) {

    override fun provideLayoutId(position: Int): Int = R.layout.item_post

    override fun provideViewModel(position: Int): ViewModel? =
        getItem(position)?.let {
            UserItemViewModel(item = it)
        }
}

object CALLBACK : DiffUtil.ItemCallback<UserItemView>() {
    override fun areItemsTheSame(oldItem: UserItemView, newItem: UserItemView): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UserItemView, newItem: UserItemView): Boolean =
        oldItem == newItem
}