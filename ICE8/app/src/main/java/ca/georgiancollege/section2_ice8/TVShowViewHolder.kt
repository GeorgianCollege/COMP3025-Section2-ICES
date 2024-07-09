package ca.georgiancollege.section2_ice8

import androidx.recyclerview.widget.RecyclerView
import ca.georgiancollege.section2_ice8.databinding.TextRowItemBinding

// TVShowViewHolder is a ViewHolder for the RecyclerView that displays a single TVShow item.
class TVShowViewHolder(private val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

    // Binds the data from a TVShow object to the views in the ViewHolder.
    fun bind(tvShow: TVShow) {
        // Set the title of the TV show to the TextView
        binding.title.text = tvShow.title
        // Set the genre of the TV show to the TextView
        binding.genre.text = tvShow.genre
        // Set the rating of the TV show to the TextView
        binding.rating.text = tvShow.rating.toString()
    }
}
