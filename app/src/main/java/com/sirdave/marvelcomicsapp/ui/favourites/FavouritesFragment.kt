package com.sirdave.marvelcomicsapp.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirdave.marvelcomicsapp.adapter.FavouriteRecyclerAdapter
import com.sirdave.marvelcomicsapp.databinding.FragmentFavouriteBinding
import com.sirdave.marvelcomicsapp.domain.model.Character

class FavouritesFragment : Fragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private val favouriteList = arrayListOf<Character>() //TODO: Get this from the viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.favouriteRecyclerView
        setUpRecyclerView()
        return root
    }

    private fun setUpRecyclerView(){
        val context = requireContext()
        val adapter = FavouriteRecyclerAdapter(context, favouriteList)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}