package ca.georgiancollege.ice6

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContactModel(
    val fullName: String,
    val contactNumber: String,
    val emailAddress: String
)
