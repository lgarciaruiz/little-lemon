package com.example.littlelemon.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
//this is basically the columns in the database table
data class MenuItemRoom(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
)

@Dao
//this is what makes the queries
interface MenuItemDao {
    @Query("SELECT * FROM MenuItemRoom")
    //used livedata because it is a live data object that is updated when the database is updated
    //used list because it is a list of menu items
    fun getAll(): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAll(vararg menu: MenuItemRoom)

    @Query("SELECT (SELECT COUNT(*) FROM MenuItemRoom) == 0")
    fun isEmpty(): Boolean
}

//database
@Database(entities = [MenuItemRoom::class], version = 2)
abstract class MenuItemDatabase : RoomDatabase() {
    abstract fun menuItemDao(): MenuItemDao
}