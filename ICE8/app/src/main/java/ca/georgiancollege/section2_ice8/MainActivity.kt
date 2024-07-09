package ca.georgiancollege.section2_ice8

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ca.georgiancollege.section2_ice8.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TVShowViewModel by viewModels()

    private lateinit var dataManager: DataManager

    // Adapter for the RecyclerView, with a click listener to open the DetailsActivity
    private val adapter = TVShowListAdapter { tvShow: TVShow ->
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra("tvShowId", tvShow.id)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firestore and DataManager
        FirebaseFirestore.setLoggingEnabled(true)
        dataManager = DataManager.instance()

        binding.firstRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.firstRecyclerView.adapter = adapter

        // Observe the LiveData from the ViewModel to update the UI
        viewModel.tvShows.observe(this) { tvShows ->
            adapter.submitList(tvShows)
        }

        // Load all TV Shows from the database when the app starts
        viewModel.loadAllTVShows()

        // TODO: replace the addButton with a FAB
        binding.addButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume()
    {
        super.onResume()
       viewModel.loadAllTVShows()
    }
}