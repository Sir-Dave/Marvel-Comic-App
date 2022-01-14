package com.sirdave.marvelcomicsapp.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirdave.marvelcomicsapp.adapter.CharacterRecyclerAdapter
import com.sirdave.marvelcomicsapp.databinding.FragmentCharacterBinding
import com.sirdave.marvelcomicsapp.domain.model.Character

class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private lateinit var recyclerView: RecyclerView

    private val binding get() = _binding!!
    private val characterList = arrayListOf<Character>() //TODO: Get this from the viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.characterRecyclerView
        setUpRecyclerView()
        return root
    }

    private fun setUpRecyclerView(){
        val context = requireContext()
        val adapter = CharacterRecyclerAdapter(context, characterList)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}