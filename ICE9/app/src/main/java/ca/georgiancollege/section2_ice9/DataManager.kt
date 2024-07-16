package ca.georgiancollege.section2_ice9

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import android.util.Log
import kotlinx.coroutines.tasks.await

class DataManager private constructor()
{
    private val db: FirebaseFirestore = Firebase.firestore

    companion object
    {
        private val TAG = "DataManager"

        @Volatile
        private var m_instance: DataManager? = null

        fun instance(): DataManager
        {
            if(m_instance == null)
            {
                synchronized(this) {
                    if(m_instance == null) {
                        m_instance = DataManager()
                    }
                }
            }
            return m_instance!!
        }
    }

    // insert a TVShow into the database
    suspend fun insert(tvShow: TVShow) {
        try {
            db.collection("tvShows").document(tvShow.id).set(tvShow).await()
        }
        catch (e: Exception) {
            Log.e(TAG, "Error inserting TVShow: ${e.message}", e)
        }
    }

    // update a TVShow in the database
    suspend fun update(tvShow: TVShow) {
        try {
            db.collection("tvShows").document(tvShow.id).set(tvShow).await()
        }
        catch (e: Exception) {
            Log.e(TAG, "Error updating TVShow: ${e.message}", e)
        }
    }

    // delete a TVShow from the database
    suspend fun delete(tvShow: TVShow) {
        try {
            db.collection("tvShows").document(tvShow.id).delete().await()
        }
        catch (e: Exception) {
            Log.e(TAG, "Error deleting TVShow: ${e.message}", e)
        }
    }

    // get all TVShows from the database
    suspend fun getAllTVShows(): List<TVShow> {
        return try {
            val result = db.collection("tvShows").get().await()
            result?.toObjects(TVShow::class.java) ?: emptyList()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting all TVShows: ${e.message}", e)
            emptyList()
        }
    }

    // get a TVShow by ID from the database
    suspend fun getTVShowById(id: String) : TVShow? {
        return try {
            val result = db.collection("tvShows").document(id).get().await()
            result?.toObject(TVShow::class.java)
        }
        catch (e: Exception) {
            Log.e(TAG, "Error getting TVShow by ID: ${e.message}", e)
            null
        }
    }

    // User CRUD Operations
    // insert a User into the database
    suspend fun insertUser(user: User) {
        try {
            db.collection("users").document(user.id).set(user).await()
        }
        catch (e: Exception) {
            Log.e(TAG, "Error inserting User: ${e.message}", e)
        }
    }

    // get a User by ID from the database
    suspend fun getUserById(id: String) : User? {
        return try {
            val result = db.collection("users").document(id).get().await()
            result?.toObject(User::class.java)
        }
        catch (e: Exception) {
            Log.e(TAG, "Error getting User by ID: ${e.message}", e)
            null
        }
    }


}