package ca.georgiancollege.ice6

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContactModel(
    @Json(name= "FullName") val fullName: String,
    @Json(name= "ContactNumber") val contactNumber: String,
    @Json(name= "EmailAddress") val emailAddress: String
)
{
    override fun toString(): String
    {
        return """Full Name: $fullName, Contact Number: $contactNumber, Email Address: $emailAddress"""
    }
}
