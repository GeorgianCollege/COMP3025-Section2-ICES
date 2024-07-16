package ca.georgiancollege.section2_ice9

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TVShowViewModel : ViewModel()
{
    // create an alias for the DataManager singleton
    private val dataManager = DataManager.instance()

    // LiveData to hold the list of TVShows
    private val m_tvShows = MutableLiveData<List<TVShow>>()
    val tvShows: LiveData<List<TVShow>> get() = m_tvShows

    // LiveData to hold the selected TVShow
    private val m_tvShow = MutableLiveData<TVShow?>()
    val tvShow: LiveData<TVShow?> get() = m_tvShow

    // LiveData to hold the selected User
    private val m_user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = m_user

    // Function to load all TVShows from the DataManager
    fun loadAllTVShows() {
        viewModelScope.launch {
            m_tvShows.value = dataManager.getAllTVShows()
        }
    }

    // Function to load a specific TVShow by ID from the DataManager
    fun loadTVShowById(id: String) {
        viewModelScope.launch {
            m_tvShow.value = dataManager.getTVShowById(id)
        }
    }

    // Function to save or update a TVShow in the DataManager
    fun saveTVShow(tvShow: TVShow) {
        viewModelScope.launch {
            if (tvShow.id.isEmpty()) {
                dataManager.insert(tvShow)
            } else {
                dataManager.update(tvShow)
            }
            loadAllTVShows()
        }
    }

    // Function to delete a TVShow from the DataManager
    fun deleteTVShow(tvShow: TVShow) {
        viewModelScope.launch {
            dataManager.delete(tvShow)
            loadAllTVShows()
        }
    }

    // User CRUD Operations
    // Function to save or update a User in the DataManager
    fun insertUser(user: User) {
        viewModelScope.launch {
            dataManager.insertUser(user)
        }
    }

    // Function to load a User by ID from the DataManager
    fun loadUserById(id: String) {
        viewModelScope.launch {
            m_user.value = dataManager.getUserById(id)
        }
    }
}


