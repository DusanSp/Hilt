package rs.myexample.hilt.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import rs.myexample.hilt.data.repository.UserRepository
import rs.myexample.hilt.domain.IUserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindFetchRepository(userRepository: UserRepository): IUserRepository
}