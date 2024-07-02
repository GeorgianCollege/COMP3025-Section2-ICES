package ca.georgiancollege.ice7

import androidx.recyclerview.widget.ListAdapter

class TVShowListAdapter(private val onItemClicked: (TVShow) -> Unit):
    ListAdapter<TVShow, TVShowViewHolder>(TVShowComparator())
{
}