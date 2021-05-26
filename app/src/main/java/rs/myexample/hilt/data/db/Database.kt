package rs.myexample.hilt.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import rs.myexample.hilt.data.db.dao.UserDao
import rs.myexample.hilt.data.db.entities.UserEntity

@Database(version = 1, exportSchema = false, entities = [UserEntity::class])
abstract class Database: RoomDatabase() {

    abstract fun userDao(): UserDao
}