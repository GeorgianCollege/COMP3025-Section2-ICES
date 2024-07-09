package ca.georgiancollege.section2_ice8

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ca.georgiancollege.section2_ice8.databinding.ActivityDetailsBinding
import java.util.UUID

class DetailsActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: TVShowViewModel by viewModels()

    private lateinit var dataManager: DataManager

    private var tvShowId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataManager = DataManager.instance()    // alias for the DataManager Singleton

        tvShowId = intent.getStringExtra("tvShowId")

        if(tvShowId != null)
        {
            viewModel.loadTVShowById(tvShowId!!)
        }
        else
        {
            binding.deleteButton.visibility = View.GONE
        }

        // Observe the LiveData from the ViewModel to update the UI
        viewModel.tvShow.observe(this) { tvShow ->
            tvShow?.let {
                binding.editTextTitle.setText(it.title)
                binding.editTextGenre.setText(it.genre)
                binding.editTextRating.setText(it.rating.toString())
            }
        }

        binding.saveButton.setOnClickListener {
            saveTVShow()
        }

        binding.deleteButton.setOnClickListener {
            deleteTVShow()
        }

        binding.cancelButton.setOnClickListener {
            finish()
        }
    }

    private fun saveTVShow()
    {
        val title = binding.editTextTitle.text.toString()
        val genre = binding.editTextGenre.text.toString()
        val rating = binding.editTextRating.text.toString().toDoubleOrNull() ?: 0.0

        if(title.isNotEmpty() && genre.isNotEmpty())
        {
            val tvShow = TVShow(id = tvShowId ?: UUID.randomUUID().toString(), title = title, genre = genre, rating = rating)
            viewModel.saveTVShow(tvShow)
            Toast.makeText(this, "TV Show Saved", Toast.LENGTH_SHORT).show()
            finish()
        }
        else
        {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteTVShow()
    {
        tvShowId?.let { _ ->
            AlertDialog.Builder(this)
                .setTitle("Delete TV Show")
                .setMessage("Are you sure you want to delete this TV show?")
                .setPositiveButton("Yes") {_, _ ->
                    viewModel.tvShow.value?.let {
                        viewModel.deleteTVShow(it)
                        Toast.makeText(this, "TV Show Deleted", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
                .setNegativeButton("No", null)
                .show()
        }
    }
}