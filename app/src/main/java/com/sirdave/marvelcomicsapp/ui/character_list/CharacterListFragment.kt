package com.sirdave.marvelcomicsapp.ui.character_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirdave.marvelcomicsapp.databinding.FragmentCharacterListBinding
import com.sirdave.marvelcomicsapp.domain.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private lateinit var recyclerView: RecyclerView

    private val binding get() = _binding!!
    private val listViewModel: CharacterListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.characterRecyclerView

        listViewModel.characters.observe(viewLifecycleOwner, { characters ->
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