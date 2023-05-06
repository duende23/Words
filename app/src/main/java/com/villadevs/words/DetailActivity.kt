package com.villadevs.words

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.villadevs.words.adapter.WordAdapter
import com.villadevs.words.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    //use a companion object as a way to organize constants and make them
    // accessible outside of the DetailActivity
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the LETTER from the Intent extras
        // intent.extras.getString returns String? (String or null)
        // so toString() guarantees that the value will be a String
        val letterId = intent?.extras?.getString(LETTER).toString()

        binding.rvRecyclerViewWords.layoutManager = LinearLayoutManager(this)
        binding.rvRecyclerViewWords.adapter = WordAdapter(letterId, this)
        binding.rvRecyclerViewWords.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        title = getString(R.string.detail_prefix) + " " + letterId

    }
}