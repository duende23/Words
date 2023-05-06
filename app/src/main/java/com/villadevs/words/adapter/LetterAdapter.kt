package com.villadevs.words.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.villadevs.words.DetailActivity
import com.villadevs.words.R

class LetterAdapter:RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    // Generates a [CharRange] from 'A' to 'Z' and converts it to a list
    private val listLetters = ('A').rangeTo('Z').toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return LetterViewHolder(layout)
    }

    override fun getItemCount(): Int =listLetters.size

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val letter = listLetters[position]
        holder.btLetter.text = letter.toString()

        holder.btLetter.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.LETTER, holder.btLetter.text.toString())
            context.startActivity(intent)
        }

    }

    class LetterViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val btLetter: Button = view.findViewById(R.id.btItem)

    }

}