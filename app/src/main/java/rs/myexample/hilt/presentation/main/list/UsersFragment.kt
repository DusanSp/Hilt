package rs.myexample.hilt.presentation.main.list

import android.os.Bundle
import android.util.Log
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import rs.myexample.hilt.R
import rs.myexample.hilt.databinding.FragmentUsersBinding
import rs.myexample.hilt.presentation.base.BaseFragment

@AndroidEntryPoint
class UsersFragment : BaseFragment<FragmentUsersBinding, UsersViewModel>() {

    override fun provideLayout(): Int = R.layout.fragment_users

    override fun provideViewModelClass(): Class<UsersViewModel> = UsersViewModel::class.java

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}