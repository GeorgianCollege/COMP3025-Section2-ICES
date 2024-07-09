package ca.georgiancollege.section2_ice8

import androidx.room.*

@Dao
interface TVShowDao
{
    // Inserts a TVShow into the database
    // If a TVShow with the same ID already exists, it will be replaced
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvShow: TVShow)

    // updates an existing TVShow in the database
    @Update
    suspend fun update(tvShow: TVShow)

    // Deletes a TVShow from the database
    @Delete
    suspend fun delete(tvShow: TVShow)

    // Retrieves all TVShows from the database
    @Query("SELECT * FROM tv_shows")
    suspend fun getAllTVShows(): List<TVShow>

    // Retrieves a TVShow by its ID from the database
    @Query("SELECT * FROM tv_shows WHERE id = :id")
    suspend fun getTVShowById(id: Int): TVShow?

}