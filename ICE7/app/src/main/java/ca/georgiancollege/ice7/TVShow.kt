package ca.georgiancollege.ice7

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity annotation marks this class as a table in the Room Database
@Entity(tableName = "tv_shows")
data class TVShow(
    // PrimaryKey annotation marks this field as the primary key
    // autoGenerate = true indicates that the field should be auto-generated
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Column to store the title of the TVShow
    val title: String,

    // Column to store the genre of the TVShow
    val genre: String,

    // Column to store the rating of the TVShow
    val rating: Double
)

