package com.sirdave.marvelcomicsapp.ui.favourites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirdave.marvelcomicsapp.R
import com.sirdave.marvelcomicsapp.db.entity.Favourite
import com.sirdave.marvelcomicsapp.util.Constants

class FavouriteRecyclerAdapter(
    val context: Context,
    private var favouriteList: List<Favourite>
    ): RecyclerView.Adapter<FavouriteRecyclerAdapter.RecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_favourite_list, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val favourite = favouriteList[position]
        holder.name.text = favourite.name
        holder.parent.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(Constants.CHARACTER_ID, favourite.id!!)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.viewFavouriteCharacter, bundle)
        }
        Glide.with(context).load(favourite.featuredImage).into(holder.image)
    }

    override fun getItemCount(): Int = favouriteList.size

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.txt_character_image)
        val name: TextView = itemView.findViewById(R.id.txt_character_name)
        val parent: CardView = itemView.findViewById(R.id.root_card_view)
    }
}