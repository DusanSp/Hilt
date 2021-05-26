package rs.myexample.hilt.presentation.main.adapter

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import rs.myexample.hilt.utils.ViewModelIdProvider

class BaseViewHolder(private val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindViewModel(viewModel: ViewModel) {
        binding.apply {
            setVariable(ViewModelIdProvider.viewModelId!!, viewModel)
            executePendingBindings()
        }
    }
}