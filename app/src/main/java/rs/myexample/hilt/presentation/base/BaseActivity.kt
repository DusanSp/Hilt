package rs.myexample.hilt.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import rs.myexample.hilt.R
import rs.myexample.hilt.utils.ViewModelIdProvider

abstract class BaseActivity<BindingT : ViewDataBinding, ViewModelT : ViewModel> :
    AppCompatActivity() {

    protected lateinit var binding: BindingT
        private set

    protected val viewModel: ViewModelT by lazy { ViewModelProvider(this).get(provideViewModelClass()) }

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupDataBinding()
        observeStateChanges()
    }

    private fun setupDataBinding() {
        binding = DataBindingUtil.setContentView(this, provideLayout())
        binding.lifecycleOwner = this
        binding.setVariable(ViewModelIdProvider.viewModelId!!, viewModel)
        binding.executePendingBindings()
    }

    @ExperimentalCoroutinesApi
    fun observeStateChanges() {
        lifecycleScope.launch {
            handleStates()
        }
    }

    @LayoutRes
    protected abstract fun provideLayout(): Int

    protected abstract fun provideViewModelClass(): Class<ViewModelT>

    protected open suspend fun handleStates() {}
}