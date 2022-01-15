package com.sirdave.marvelcomicsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirdave.marvelcomicsapp.R
import com.sirdave.marvelcomicsapp.domain.model.Character

class CharacterRecyclerAdapter(
    val context: Context,
    private var characterList: List<Character>
    ): RecyclerView.Adapter<CharacterRecyclerAdapter.RecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_characters_grid, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val character = characterList[position]
        holder.name.text = character.name
        Glide.with(context).load(character.featuredImage).into(holder.image)
    }

    override fun getItemCount(): Int = characterList.size

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.txt_character_image)
        var name: TextView = itemView.findViewById(R.id.txt_character_name)
    }
}