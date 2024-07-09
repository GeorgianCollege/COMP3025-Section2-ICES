package ca.georgiancollege.section2_ice8

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class TVShow(
    @DocumentId val id: String = "",
    val title: String,
    val genre: String,
    val rating: Double
)
{
    // No-argument constructor required for Firestore deserialization
    constructor() : this("", "", "", 0.0)
}


