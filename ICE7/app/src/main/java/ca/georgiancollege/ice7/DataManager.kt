package ca.georgiancollege.ice7

import android.content.Context

class DataManager private constructor(private val database: AppDatabase)
{

    companion object
    {
        private lateinit var database: AppDatabase

        @Volatile
        private var m_instance: DataManager? = null

        fun instance(context: Context): DataManager
        {
            if(m_instance == null)
            {
                synchronized(this) {
                    if(m_instance == null) {
                        m_instance = DataManager(AppDatabase.getDatabase(context))
                        database = m_instance!!.database
                    }
                }
            }
            return m_instance!!
        }
    }

    suspend fun insert(tvShow: TVShow) = Companion.database.tvShowDao().insert(tvShow)

    suspend fun update(tvShow: TVShow) = Companion.database.tvShowDao().update(tvShow)

    suspend fun delete(tvShow: TVShow) = Companion.database.tvShowDao().delete(tvShow)

    suspend fun getAllTVShows() = Companion.database.tvShowDao().getAllTVShows()

    suspend fun getTVShowById(id: Int) = Companion.database.tvShowDao().getTVShowById(id)
}