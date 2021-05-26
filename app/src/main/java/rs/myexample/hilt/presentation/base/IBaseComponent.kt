package rs.myexample.hilt.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup

interface IBaseComponent<BindingT, ViewModelT> {
    fun onCreateDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): BindingT
}