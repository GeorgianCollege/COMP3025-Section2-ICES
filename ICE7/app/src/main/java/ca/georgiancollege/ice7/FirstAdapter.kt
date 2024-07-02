package ca.georgiancollege.ice7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.georgiancollege.ice7.databinding.TextRowItemBinding

// A control class and a wrapper for the first RecyclerView
class FirstAdapter(private val dataSet: Array<TVShow>) :
    RecyclerView.Adapter<FirstAdapter.ViewHolder>()
{

    // inner class ViewHolder
    class ViewHolder(val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root)

    // Inflates the text_row_item layout and returns the ViewHolder (custom table view cell)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder
    {
        // Inflate the layout with view binding
        val binding = TextRowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    // Binds the data to the view
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int)
    {
        // Use view binding to set the text
        viewHolder.binding.title.text = dataSet[position].title
        viewHolder.binding.subTitle.text = dataSet[position].subTitle
    }

    // Returns the size of the data set
    override fun getItemCount() = dataSet.size
}
