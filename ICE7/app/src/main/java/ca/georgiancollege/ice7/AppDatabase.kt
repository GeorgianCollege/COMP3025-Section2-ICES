package ca.georgiancollege.ice7

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// This annotation marks the class as a Room Database
@Database(entities = [TVShow::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
{
    // This method returns an instance of the TVShowDao interface
    abstract fun tvShowDao(): TVShowDao

    companion object
    {
        // Volatile annotation ensures that the instance is always up-to-date and thread-safe
        @Volatile
        private var m_instance: AppDatabase? = null

        // This function returns the singleton instance of the AppDatabase
        // If the instance is null, it creates a new instance using Room.databaseBuilder
        fun getDatabase(context: Context): AppDatabase
        {
            // Multiple threads can ask for the database at the same time,
            // ensuring that only one thread can access the database at a time.
            return m_instance ?: synchronized(this) {
                // Create an instance of the database using Room.databaseBuilder
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "media_database" // name of the database file
                ).build()
                // Assign the newly created database instance to INSTANCE
                m_instance = instance

                // Return the instance
                return instance
            }
        }
    }
}