package com.sirdave.marvelcomicsapp.ui.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sirdave.marvelcomicsapp.R
import com.sirdave.marvelcomicsapp.databinding.FragmentCharacterBinding
import com.sirdave.marvelcomicsapp.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt(Constants.CHARACTER_ID)?.let { characterId ->
            viewModel.searchCharacterById(characterId)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.characterId.observe(viewLifecycleOwner, { character ->
            //TODO: Set the view here
        })

        return root
    }
}