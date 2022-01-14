package com.sirdave.marvelcomicsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sirdave.marvelcomicsapp.R
import com.sirdave.marvelcomicsapp.domain.Character

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
        holder.setData(character, position)
    }

    override fun getItemCount(): Int = characterList.size

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.txt_character_image)
        val name: TextView = itemView.findViewById(R.id.txt_character_name)

        fun setData(character: Character, position: Int){
            //TODO: Display the data obtained here
        }
    }
}