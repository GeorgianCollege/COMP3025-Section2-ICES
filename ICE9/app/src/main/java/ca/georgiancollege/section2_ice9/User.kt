package ca.georgiancollege.section2_ice9

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    @DocumentId var id: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var email: String = ""
)
