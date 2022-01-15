package com.sirdave.marvelcomicsapp.ui.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirdave.marvelcomicsapp.adapter.CharacterRecyclerAdapter
import com.sirdave.marvelcomicsapp.databinding.FragmentCharacterBinding
import com.sirdave.marvelcomicsapp.domain.model.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private lateinit var recyclerView: RecyclerView

    private val binding get() = _binding!!
    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.characterRecyclerView

        viewModel.characters.observe(viewLifecycleOwner, { characters ->
            setUpRecyclerView(characters)
        })
        return root
    }

    private fun setUpRecyclerView(characterList: List<Character>){
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