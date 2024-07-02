package ca.georgiancollege.ice7

import androidx.room.Database
import androidx.room.RoomDatabase

// This annotation marks the class as a Room Database
@Database(entities = [TVShow::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
{


}