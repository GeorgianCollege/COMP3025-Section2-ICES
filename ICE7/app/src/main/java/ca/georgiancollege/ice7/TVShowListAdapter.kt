package ca.georgiancollege.ice7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ca.georgiancollege.ice7.databinding.TextRowItemBinding

class TVShowListAdapter(private val onItemClicked: (TVShow) -> Unit):
    ListAdapter<TVShow, TVShowViewHolder>(TVShowComparator())
{

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder
        {
            val binding = TextRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TVShowViewHolder(binding)
        }

        override fun onBindViewHolder(holder: TVShowViewHolder, position: Int)
        {
            val current = getItem(position)

            holder.bind(current)

            holder.itemView.setOnClickListener {
                onItemClicked(current)
            }
        }

}