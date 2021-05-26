package rs.myexample.hilt.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import rs.myexample.hilt.utils.ViewModelIdProvider

abstract class BaseFragment<BindingT : ViewDataBinding, ViewModelT : ViewModel> : Fragment(),
    IBaseComponent<BindingT, ViewModelT> {

    private lateinit var localView: View

    protected lateinit var binding: BindingT
        private set

    protected val viewModel: ViewModelT by lazy {
        if (useActivityViewModel())
            ViewModelProvider(requireActivity()).get(provideViewModelClass())
        else
            ViewModelProvider(this).get(provideViewModelClass())
    }

    @LayoutRes
    protected abstract fun provideLayout(): Int

    protected abstract fun provideViewModelClass(): Class<ViewModelT>

    protected open suspend fun handleStates() {}

    protected open fun useActivityViewModel(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init(inflater, container)
        localView = binding.root
        return binding.root
    }

    protected open fun init(inflater: LayoutInflater, container: ViewGroup?) {
        binding = onCreateDataBinding(inflater, container)
        setDataBinding()
    }

    override fun onCreateDataBinding(inflater: LayoutInflater, container: ViewGroup?): BindingT =
        if (::localView.isInitialized) {
            DataBindingUtil.getBinding(localView)!!
        } else {
            DataBindingUtil.inflate(inflater, provideLayout(), container, false)
        }

    protected open fun setDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(ViewModelIdProvider.viewModelId!!, viewModel)
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeStateChanges()
    }

    @ExperimentalCoroutinesApi
    fun observeStateChanges() {
        lifecycleScope.launch {
            handleStates()
        }
    }
}