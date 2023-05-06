package com.villadevs.words.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.villadevs.words.DetailActivity
import com.villadevs.words.R

class WordAdapter(private val letterId:String, val context: Context):RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private val filteredWords: List<String>

    init {
        // Retrieve the list of words from res/values/arrays.xml
        val words = context.resources.getStringArray(R.array.words).toList()

        // Returns items in a collection if the conditional clause is true,
        // in this case if an item starts with the given letter,
        // ignoring UPPERCASE or lowercase.
        filteredWords = words
            .filter { it.startsWith(letterId, ignoreCase = true) }
            // Returns a collection that it has shuffled in place
            .shuffled()
            // Returns the first n items as a [List]
            .take(5)
            // Returns a sorted version of that [List]
            .sorted()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return WordViewHolder(layout)
    }

    override fun getItemCount(): Int = filteredWords.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = filteredWords[position]
        holder.btWord.text = word

        // Needed to call startActivity
        val context = holder.view.context

        holder.btWord.setOnClickListener {
            val queryUrl : Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}$word")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }

    }

    class WordViewHolder(val view: View):RecyclerView.ViewHolder(view) {
        val btWord = view.findViewById<Button>(R.id.btItem)
    }
}