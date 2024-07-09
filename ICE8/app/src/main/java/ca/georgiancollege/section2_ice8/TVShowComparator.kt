package ca.georgiancollege.section2_ice8

import androidx.recyclerview.widget.DiffUtil

// This is a utility class that helps the Recycler Adapter determine
// how to efficiently update the list when the data changes
class TVShowComparator: DiffUtil.ItemCallback<TVShow>()
{
    // This method checks if two items represent the same entity by comparing their IDs.
    override fun areItemsTheSame(oldItem: TVShow, newItem: TVShow): Boolean
    {
        return oldItem.id == newItem.id
    }

    // this method checks if the contents of two items are the same by comparing their properties.
    override fun areContentsTheSame(oldItem: TVShow, newItem: TVShow): Boolean
    {
        return oldItem == newItem
    }
}