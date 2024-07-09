package ca.georgiancollege.section2_ice8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ca.georgiancollege.section2_ice8.databinding.TextRowItemBinding

// TVShowListAdapter is an adapter for the RecyclerView that displays a list of TVShow items.
// It extends ListAdapter, which helps with efficiently updating the list using the TVShowComparator.
class TVShowListAdapter(private val onItemClicked: (TVShow) -> Unit) :
    ListAdapter<TVShow, TVShowViewHolder>(TVShowComparator()) {

    // Called when the RecyclerView needs a new ViewHolder to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        // Inflate the item layout and create a binding object
        val binding = TextRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Return a new ViewHolder instance with the binding object
        return TVShowViewHolder(binding)
    }

    // Called by the RecyclerView to display the data at the specified position.
    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        // Get the TVShow item at the given position
        val current = getItem(position)
        // Bind the TVShow item to the ViewHolder
        holder.bind(current)
        // Set a click listener on the itemView to handle item clicks
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
    }
}
