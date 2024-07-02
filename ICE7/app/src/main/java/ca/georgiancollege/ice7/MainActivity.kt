package ca.georgiancollege.ice7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ca.georgiancollege.ice7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        // create an array of TV shows (mock data)
        val favouriteTVShows = arrayOf(
            TVShow("House of the Dragon", "HBO"),
            TVShow("Lord of the Rings", "Prime Video"),
            TVShow("Andor", "Disney"),
            TVShow("Severance", "AppleTv"),
            TVShow("Star Trek: Strange New Worlds", "Paramount+")
        )

        // create an instance of the FirstAdapter and pass in the array of TV shows
        val firstAdapter = FirstAdapter(favouriteTVShows)
        binding.firstRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = firstAdapter
        }

         */

    }
}