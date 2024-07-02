package ca.georgiancollege.ice7

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.georgiancollege.ice7.databinding.ActivityDetailsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDetailsBinding

    private lateinit var dataManager: DataManager

    private var tvShowId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataManager = DataManager.instance(this)    // alias for the DataManager Singleton

        tvShowId = intent.getIntExtra("tvShowId", -1).takeIf { it != -1 }

        if(tvShowId != null)
        {
            loadTVShow(tvShowId!!)
        }
        else
        {
            binding.deleteButton.visibility = View.GONE
        }

        binding.saveButton.setOnClickListener {
            saveTVShow()
        }

        binding.deleteButton.setOnClickListener {
            //deleteTVShow()
        }

        binding.cancelButton.setOnClickListener {
            finish()
        }
    }

    private fun loadTVShow(id: Int)
    {
        CoroutineScope(Dispatchers.Main).launch {
            val tvShow = dataManager.getTVShowById(id)
            tvShow?.let {
                binding.editTextTitle.setText(it.title)
                binding.editTextGenre.setText(it.genre)
                binding.editTextRating.setText(it.rating.toString())
            }
        }
    }

    private fun saveTVShow()
    {
        val title = binding.editTextTitle.text.toString()
        val genre = binding.editTextGenre.text.toString()
        val rating = binding.editTextRating.text.toString().toDoubleOrNull() ?: 0.0

        if(title.isNotEmpty() && genre.isNotEmpty())
        {
            val tvShow = TVShow(id = tvShowId ?: 0, title=title, genre=genre, rating=rating)
            CoroutineScope(Dispatchers.Main).launch {
                if (tvShowId == null)
                {
                    dataManager.insert(tvShow)
                    Toast.makeText(this@DetailsActivity, "TV Show Added", Toast.LENGTH_SHORT).show()
                } else {
                    dataManager.update(tvShow)
                    Toast.makeText(this@DetailsActivity, "TV Show Updated", Toast.LENGTH_SHORT).show()
                }
                finish()
            }
        }
        else
        {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }
}